package com.example.a9320;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

   EditText editText;
   EditText editText2;
   EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        Intent intentToFirstActivity = new Intent();
        intentToFirstActivity.putExtra("key","Подтвердите данные!");
        setResult(RESULT_CANCELED,intentToFirstActivity);
    }

    public void onCoseActivity(View view) {
        Intent intentToFirstActivity = new Intent();
        intentToFirstActivity.putExtra("key",editText.getText().toString());
        intentToFirstActivity.putExtra("key",editText2.getText().toString());
        intentToFirstActivity.putExtra("key",editText3.getText().toString());
        setResult(RESULT_OK,intentToFirstActivity);
        this.finish();

    }
}

