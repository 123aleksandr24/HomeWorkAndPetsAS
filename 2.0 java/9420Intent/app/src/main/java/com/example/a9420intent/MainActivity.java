package com.example.a9420intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void onWebSearch(View view) {
//        Intent intentToWebSearch = new Intent (Intent.ACTION_VIEW, Uri.parse("http://skillbox.ru"));
//        startActivity(Intent.createChooser(intentToWebSearch,"Вы всегда будете выбирать")); //постоянный выбор каким браузером открыввать
//    }

    public void onOpenSendActivity(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_PHONE_NUMBER,"8-8888-888-88-88");
        sendIntent.putExtra(Intent.EXTRA_TEXT,"Hi diar friend");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
