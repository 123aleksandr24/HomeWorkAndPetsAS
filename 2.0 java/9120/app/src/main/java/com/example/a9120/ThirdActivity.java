package com.example.a9120;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent gettingIntent = getIntent();
        String getTextFromSecondActivity = gettingIntent.getStringExtra("toSecondActivity");
        TextView textView = findViewById(R.id.newTextView);
        textView.setText(getTextFromSecondActivity);


        //int i = 3;
//        int getNumberFromSecondActivity = gettingIntent.getIntExtra("3",3);
//        TextView textView = findViewById(R.id.newTextView);
//        textView.setInputType(getNumberFromSecondActivity);
}

}
