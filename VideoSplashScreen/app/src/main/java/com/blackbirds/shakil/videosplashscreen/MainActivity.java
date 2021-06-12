package com.blackbirds.shakil.videosplashscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    AppCompatButton btnNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        btnNextActivity = findViewById(R.id.btnNextActivity);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();

        /*videoView.setOnPreparedListener(mp -> {
            mp.start();
            //imageView.setVisibility(View.GONE);
        });*/

        /** If you want video was play again and again */
        videoView.setOnCompletionListener(mp -> {

            if (isFinishing()){
                return;
            }
            startActivity(new Intent(this, SecondActivity.class));
            finish();
        });

        btnNextActivity.setOnClickListener(v -> {
            startActivity(new Intent(this, SecondActivity.class));
        });
    }
}