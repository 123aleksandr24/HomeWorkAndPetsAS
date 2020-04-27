package com.example.a95120neyavmiieintenti;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
    }

    public void onAboutAuters(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


    public void onCall(View view) {

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(String.valueOf(number)));

        startActivity(intent(Intent.ACTION_CALL));
    }
}

