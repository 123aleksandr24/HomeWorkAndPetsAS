package com.example.a11220stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int iteration = 0;
    boolean beginning;
    boolean wasBeginning;
    ArrayList<String> textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!= null){
            iteration = savedInstanceState.getInt("iterations");
            beginning = savedInstanceState.getBoolean("beginning");
            textView = savedInstanceState.getStringArrayList("textView");
        }

        begin();
    }

        void begin(){
            final TextView textView2 = findViewById(R.id.textView2);
            final Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView2.setText(String.valueOf(iteration));
                    if (beginning){
                        iteration++;
                    }
                    handler.postDelayed(this,1000);
                }
            });

        }

    public void onClickStart(View view) {
        TextView textView = findViewById(R.id.textView);
        textView.setText("Секундомер запущен ");
        beginning = true;
    }

    public void onClickStop(View view) {
        TextView textView = findViewById(R.id.textView);
        textView.setText("Секундомер остановлен ");
        beginning = false;
    }

    public void onClickReset(View view) {
        TextView textView = findViewById(R.id.textView);
        textView.setText("Секундомер сброшен ");
        beginning = false;
        iteration = 0;
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasBeginning = beginning;
        beginning = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        wasBeginning = beginning;
        wasBeginning = true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("iterations", iteration);
        outState.putBoolean("beginning", beginning);
        outState.putString("textView", String.valueOf(textView));
    }
}
