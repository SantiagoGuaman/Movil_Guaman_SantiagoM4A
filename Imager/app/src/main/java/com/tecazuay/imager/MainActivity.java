package com.tecazuay.imager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton button = findViewById(R.id.btn_img_act1);
        button.setOnClickListener(l -> abrirCamera());
    }

    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private void abrirCamera() {
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamera, REQUEST_IMAGE_CAPTURE, null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle info = data.getExtras();
            Bitmap image = (Bitmap) info.get("data");
            ImageView imageView = findViewById(R.id.image_act1);
            imageView.setImageBitmap(image);
        }
    }
}