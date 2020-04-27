package com.example.a7120;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.label);
        textView2 = findViewById(R.id.label2);

    }

    public void onClose(View view){
        this.finish();
    }

    public void onChangeTextView (View view){
        textView.setText("Hi SkillBox");
    }

    public void onChangeTextView2 (View view){
        textView2.setText("SUPER TEXT");
    }

}
