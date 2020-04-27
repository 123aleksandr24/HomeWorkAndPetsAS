package com.example.a94220intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        String message = intent.getStringExtra(Intent.EXTRA_TEXT);

        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);

        textView3.setText(phoneNumber);
        textView4.setText(message);
    }
}
