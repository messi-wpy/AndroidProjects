package comw.bignerdranch.androidboy.imagecut;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by androidboy on 18-2-5.
 */

public class BoxDrawingView extends View {
    private static final String TAG = "BoxDrawingview";
    private Uri mUri;
    private Bitmap mBitmap;
    private Matrix mMatrix = new Matrix();
    private int width;
    private int height;
    private float currentX;
    private float currentY;
    private float lastX = -1;
    private float lastY = -1;
    private float imageWidth;
    private float imageHeight;
    private float radius;
    private double lastDis;
    private double currentDis;
    private float scaleDate = 1;
    private float xMove;
    private float yMove;
    private float scale;
    private float centerX;
    private float centerY;
    private Paint paint = new Paint();
    public String STATUS = "INIT";

    public BoxDrawingView(Context context) {
        this(context, null);
    }

    public BoxDrawingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setImageUri(Bitmap bitmap) {
        mBitmap = bitmap;
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        switch (STATUS) {
            case "INIT":
                init(canvas);
                break;
            case "MOVE":
                canvas.drawBitmap(mBitmap, mMatrix, null);
                addCircle(canvas, paint);
                break;
            case "SCALE":
                canvas.drawBitmap(mBitmap, mMatrix, null);
                addCircle(canvas, paint);
                break;
            case "CUT":
                cutImage(canvas);
                break;


        }

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            // 分别获取到ZoomImageView的宽度和高度
            width = getWidth();
            height = getHeight();
            centerX = width / 2;
            centerY = height / 2;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN://一个手指按压时出来
                lastX = event.getX();
                lastY = event.getY();
                Log.i(TAG, "onTouchEvent: down");
                break;

            case MotionEvent.ACTION_POINTER_DOWN://两个手指按压时才出来
                if (event.getPointerCount() == 2) {
                    lastDis = distanceBetweenFingers(event);
                }
                Log.i(TAG, "onTouchEvent: pointDown");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "onTouchEvent: move");
                if (event.getPointerCount() == 1) {
                    STATUS = "MOVE";
                    currentY = event.getY();
                    currentX = event.getX();
                    xMove = currentX - lastX;
                    yMove = currentY - lastY;
                    centerX += xMove;
                    centerY += yMove;
                    lastX = event.getX();
                    lastY = event.getY();

                    /*    if (centerY>=(height/2-((imageHeight*scale*scaleDate)/2-radius))&&
                                centerY<=height/2+((imageHeight*scale*scaleDate)/2-radius)) {
                            mMatrix.postTranslate(0, yMove);
                        }
                        if (centerX>=(width/2-((imageWidth*scaleDate*scale)/2-radius))&&
                                centerX<=width/2+((imageWidth*scale*scaleDate)/2-radius)){
                            mMatrix.postTranslate(xMove,0);
                        }*/

                    mMatrix.postTranslate(xMove, yMove);
                    invalidate();
                    break;

                }

                //表示两个手指是放缩，
                else {

                    currentDis = distanceBetweenFingers(event);
                    scaleDate = (float) (currentDis / lastDis);
                    lastDis = currentDis;
                    mMatrix.postScale(scaleDate, scaleDate);
                    STATUS = "SCALE";
                    invalidate();
                    break;
                }

        }
        return true;
    }

    //初始化图片，判断图片的长和宽与屏幕的大小比较，进行放缩并让图片平移使其居中显示
    public void initImage(Canvas canvas, Paint paint) {

        mMatrix.reset();
        imageHeight = mBitmap.getHeight();
        imageWidth = mBitmap.getWidth();
        if (imageWidth > width || imageHeight > height) {
            if (imageHeight - height > imageWidth - width) {

                scale = height / (imageHeight * 1.3f);
                mMatrix.postScale(scale, scale);
                float translateX = (width - (imageWidth * scale)) / 2;
                float translateY = (height - (imageHeight * scale)) / 2;
                mMatrix.postTranslate(translateX, translateY);
                imageWidth = imageWidth * scale;
                imageHeight = imageHeight * scale;
            } else {
                float scale = width / (imageWidth * 1.3f);
                mMatrix.postScale(scale, scale);
                float translateY = (height - (imageHeight * scale)) / 2;
                float translateX = (width - (imageWidth * scale)) / 2;
                mMatrix.postTranslate(translateX, translateY);
                imageWidth = imageWidth * scale;
                imageHeight = imageHeight * scale;
            }
        }//这是长和宽都小于屏幕，则让他剧中显示
        else {
            float translateX = (width - imageWidth) / 2;
            float translateY = (height - imageHeight) / 2;
            mMatrix.postTranslate(translateX, translateY);
        }

        canvas.drawBitmap(mBitmap, mMatrix, paint);

    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public void addCircle(Canvas canvas, Paint paint) {

        paint.setAntiAlias(false); //去锯齿
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        //  paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        float circleWidth = width / 2;
        float circleHeight = height / 2;
        if (imageHeight > imageWidth) {
            radius = imageWidth / 2;
        } else {
            radius = imageHeight / 2;
        }
        canvas.drawCircle(circleWidth, circleHeight, radius, paint);

    }

    public void init(Canvas canvas) {

        initImage(canvas, paint);
        addCircle(canvas, paint);
        //  paint.setXfermode(null);

    }

    private double distanceBetweenFingers(MotionEvent event) {
        float disX = Math.abs(event.getX(0) - event.getX(1));
        float disY = Math.abs(event.getY(0) - event.getY(1));
        return Math.sqrt(disX * disX + disY * disY);
    }

    public void cutImage(Canvas canvas) {
        Path path = new Path();
        path.addCircle(width / 2, height / 2, radius, Path.Direction.CCW);
        canvas.clipPath(path, Region.Op.REPLACE);
        canvas.drawBitmap(mBitmap, mMatrix, paint);
    }


}
