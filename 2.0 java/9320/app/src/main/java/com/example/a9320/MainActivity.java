package com.example.a9320;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int CODEFORSECONDACTIVITY = 1 ;

    TextView textView;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent getIntentMain3Activity = getIntent();
        String getTextFromMain3Activity = getIntentMain3Activity.getStringExtra("toFirstActivity");
        TextView group = findViewById(R.id.group);
        group.setText(getTextFromMain3Activity);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivityForResult(intent,CODEFORSECONDACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CODEFORSECONDACTIVITY){
            if (resultCode == RESULT_CANCELED){
                textView.setText(null);
                textView2.setText(null);
                textView3.setText(data.getStringExtra("key"));
                textView3.setTextColor(Color.parseColor ("#FF0000"));
            } else if (resultCode == RESULT_OK){
                textView.setText(data.getStringExtra("key"));
                textView.setTextColor(Color.parseColor ("#8A2BE2"));
                textView2.setText(data.getStringExtra("key2"));
                textView2.setTextColor(Color.parseColor ("#8A2BE2"));
                textView3.setText(data.getStringExtra("key3"));
                textView3.setTextColor(Color.parseColor ("#8A2BE2"));
            }
        }
    }


    public void onThirdActivity(View view) {
        Intent ThirdActivityIntent = new Intent(this,Main3Activity.class);
        startActivity(ThirdActivityIntent);
    }
}
