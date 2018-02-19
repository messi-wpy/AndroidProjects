package comw.bignerdranch.androidboy.imagecut;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by androidboy on 18-2-5.
 */

public class BoxDrawingView extends View {
    private static final String TAG="BoxDrawingview";
    private Uri mUri;
    private Bitmap mBitmap;
    private Matrix mMatrix=new Matrix();
    private int width;
    private int height;
    private float currentX;
    private float currentY;
    private float lastX=-1;
    private float lastY=-1;
    private float imageWidth;
    private float imageHeight;
    private float radius;
     private Paint paint=new Paint();
     private  String STATUS="INIT";
    public BoxDrawingView(Context context){
        this(context,null);
    }

    public BoxDrawingView (Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    public void setImageUri (Bitmap bitmap){
        mBitmap=bitmap;
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas){
        switch (STATUS){
            case "INIT":
                init(canvas);
                break;
            case "MOVE":
                canvas.drawBitmap(mBitmap,mMatrix,null);
                addCircle(canvas,paint);
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
            currentX=width/2;
            currentY=height/2;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_MOVE:
                if(event.getPointerCount()==1){
                    STATUS="MOVE";
                    if(lastX==-1&&lastY==-1){
                        lastX=event.getX();
                        lastY=event.getY();
                    }
                    currentY=event.getY();
                    currentX=event.getX();
                    float xMove=currentX-lastX;
                    float yMove=currentY-lastY;

                    lastX=event.getX();
                    lastY=event.getY();

                    mMatrix.postTranslate(xMove,yMove);
                    invalidate();
                    break;

                }

        }
        return true;
    }

            //初始化图片，判断图片的长和宽与屏幕的大小比较，进行放缩并让图片平移使其居中显示
    public void initImage(Canvas canvas,Paint paint){

        mMatrix.reset();
        imageHeight=mBitmap.getHeight();
        imageWidth=mBitmap.getWidth();
        if (imageWidth>width||imageHeight>height){
            if (imageHeight-height>imageWidth-width){
                float scale=height/(imageHeight*1.5f);
                mMatrix.postScale(scale,scale);
                float translateX=(width-(imageWidth*scale))/2;
                float translateY=(height-(imageHeight*scale))/2;
                mMatrix.postTranslate(translateX,translateY);
                imageWidth=imageWidth*scale;
                imageHeight=imageHeight*scale;
            }
            else {
                float scale=width/(imageWidth*1.5f);
                mMatrix.postScale(scale,scale);
                float translateY=(height-(imageHeight*scale))/2;
                float translateX=(width-(imageWidth*scale))/2;
                mMatrix.postTranslate(translateX,translateY);
                imageWidth=imageWidth*scale;
                imageHeight=imageHeight*scale;
            }
        }//这是长和宽都小于屏幕，则让他剧中显示
        else {
            float translateX=(width-imageWidth)/2;
            float translateY=(height-imageHeight)/2;
            mMatrix.postTranslate(translateX,translateY);
        }

        canvas.drawBitmap(mBitmap, mMatrix, paint);

    }

    public void addCircle(Canvas canvas,Paint paint){

        paint.setAntiAlias(false); //去锯齿
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
     //  paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        float circleWidth=width/2;
        float circleHeight=height/2;
        if(imageHeight>imageWidth){
             radius=imageWidth/2;
        }else {
             radius=imageHeight/2;
        }
        canvas.drawCircle(circleWidth,circleHeight,radius,paint);

    }

    public void init(Canvas canvas)
    {

        initImage(canvas,paint);
        addCircle(canvas,paint);
      //  paint.setXfermode(null);

    }


}
