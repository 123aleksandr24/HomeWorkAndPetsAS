package com.example.a9120;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void onOpenSecondActivity(View view) {
        Intent secondActivityTntent = new Intent (this, SecondActivity.class);
        startActivity(secondActivityTntent);
    }
}
