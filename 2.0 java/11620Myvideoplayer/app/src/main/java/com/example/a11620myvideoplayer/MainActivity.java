package com.example.a11620myvideoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    int intPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();

        videoView = findViewById(R.id.videoView);
        String pathToVideoFile = "android.resourse://com.example.myvideopleer/" + R.raw.videoplayback;
        videoView.setVideoPath(pathToVideoFile);

        if(savedInstanceState != null){
            intPosition = savedInstanceState.getInt("intPosition");
            videoView.seekTo(intPosition);
            videoView.start();
        } else {
            videoView.start();
        }

        videoView.start();


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        intPosition = videoView.getCurrentPosition();
        outState.putInt("intPosition",intPosition);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast toast = Toast.makeText(this,"onStop", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,100);
        toast.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast toast = Toast.makeText(this,"onRestart", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,200);
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast toast = Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,300);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast toast = Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,400);
        toast.show();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        Toast toast = Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER,0,0);
//        toast.show();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast toast = Toast.makeText(this,"onStart", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER,0,200);
//        toast.show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast toast = Toast.makeText(this,"onStop", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER,0,600);
//        toast.show();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast toast = Toast.makeText(this,"onRestart", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER,0,450);
//        toast.show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast toast = Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER,0,950);
//        toast.show();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast toast = Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER,0,350);
//        toast.show();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast toast = Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER,0,650);
//        toast.show();
//    }
//
}
