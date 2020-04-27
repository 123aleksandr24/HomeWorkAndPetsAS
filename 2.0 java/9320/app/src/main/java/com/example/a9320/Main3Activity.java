package com.example.a9320;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    EditText textForFirstActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textForFirstActivity.findViewById(R.id.textForFirstActivity);
    }

    public void onFirstActivity(View view) {
        Intent onFirstActivity = new Intent(this,MainActivity.class);
        String editTextmassage = textForFirstActivity.getText().toString();
        onFirstActivity.putExtra("toFirstActivity", editTextmassage);
        startActivity(onFirstActivity);
    }
}
