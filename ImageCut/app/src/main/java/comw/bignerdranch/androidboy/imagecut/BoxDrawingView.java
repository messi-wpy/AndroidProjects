package comw.bignerdranch.androidboy.imagecut;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by androidboy on 18-2-5.
 */

public class BoxDrawingView extends View {
    private static final String TAG="BoxDrawingview";
    private Uri mUri;
    private Bitmap mBitmap;
    private Matrix mMatrix=new Matrix();
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
        canvas.drawBitmap(mBitmap, mMatrix, null);
    }




}
