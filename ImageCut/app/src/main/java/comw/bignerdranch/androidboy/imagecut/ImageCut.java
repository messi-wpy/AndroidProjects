package comw.bignerdranch.androidboy.imagecut;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;

/**
 * Created by androidboy on 18-2-5.
 */

public class ImageCut extends AppCompatActivity {
    private ImageView mImageView;
    private Bitmap mBitmap;
    private Uri mUri;
    private BoxDrawingView mBoxDrawingView;
    private Button mButton;
    private final static String TAG = "ImagCut";
    private final static String PHOTO_KEY = "photoKey";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draw_view);
        mButton = findViewById(R.id.cutButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBoxDrawingView.setSTATUS("CUT");
                mBoxDrawingView.invalidate();

            }
        });
        mBoxDrawingView = (BoxDrawingView) findViewById(R.id.image_view);
        // mImageView=findViewById(R.id.photoView);
        mUri = getIntent().getData();

        try {
            mBitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(mUri));
            mBoxDrawingView.setImageUri(mBitmap);
        } catch (FileNotFoundException e) {
            Log.i(TAG, "onCreate:wrong ");
        }


    }

    public static Intent newIntent(Context context, Uri uri) {
        Intent intent = new Intent(context, ImageCut.class);
        intent.setData(uri);
        return intent;
    }


}
