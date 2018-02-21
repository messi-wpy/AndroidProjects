package comw.bignerdranch.androidboy.imagecut;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageView;
    private Button cutButton;
    private Button photoButton;
    private Bitmap photoBit;
    private Uri mUri;
    private final static int IMAGE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);
        cutButton = findViewById(R.id.cutButton);
        photoButton = findViewById(R.id.photoButton);

        mImageView.setOnClickListener(this);
        cutButton.setOnClickListener(this);
        photoButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.photoButton:
                //创建一个打开相册的intent
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.addCategory(Intent.CATEGORY_OPENABLE);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, IMAGE_CODE);
                break;

            case R.id.cutButton:
                if (photoBit == null) {
                    Toast.makeText(this, "请先选择照片", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent = ImageCut.newIntent(MainActivity.this, mUri);
                    startActivity(intent);
                }

        }
    }

    @Override
    public void onActivityResult(int req, int res, Intent data) {
        if (res == RESULT_OK && req == IMAGE_CODE) {
            mUri = data.getData();
            if (mUri != null) {
                try {
                    photoBit = BitmapFactory.decodeStream(getContentResolver().openInputStream(mUri));
                    mImageView.setImageBitmap(photoBit);
                } catch (FileNotFoundException e) {
                    Toast.makeText(this, "没有找到", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
