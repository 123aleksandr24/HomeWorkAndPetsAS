package com.example.petjavanotification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public final static String FILE_NAME = "filename"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById (R.id.tv);

        Intent intent = getIntent();

        String fileName = intent.getStringExtra(FILE_NAME);
        if(!TextUtils.isEmpty(fileName))
            tv.setText(fileName);
    }

    public void onClickStart (View v) {
        startService (new Intent (this,MyService.class));
    }

    public void onClickStop (View v) {
        stopService (new Intent (this,MyService.class))
    }
}
