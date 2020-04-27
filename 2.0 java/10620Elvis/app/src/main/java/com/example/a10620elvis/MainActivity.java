package com.example.a10620elvis;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.elvis_tutty_frutty);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.Elvis_Presley_Lets_Twist_again);
    }

    public void onStart(View view) {
        mediaPlayer.start();
    }

    public void onNext(View view) {
        //mediaPlayer.getSelectedTrack(1);
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            mediaPlayer2.start();
            TextView textView = findViewById(R.id.textView);
            textView.setText("Elvis_Presley_Lets_Twist is playing");
        } else if (mediaPlayer2.isPlaying()){
            mediaPlayer.pause();
            mediaPlayer2.start();
            TextView textView = findViewById(R.id.textView);
            textView.setText("Elvis tutty frutty is playing");
        }
    }
}
