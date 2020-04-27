package com.example.a9120;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = findViewById(R.id.editText);

    }

    public void onOpenThirdActivity(View view) {
        Intent thirdActivityIntent = new Intent (this, ThirdActivity.class);
        String editTextMessage = editText.getText().toString();
        thirdActivityIntent.putExtra("toSecondActivity",editTextMessage); //ключ toSecondActivity уникальный


//        int editNumberMessage = editText.getText().charAt(3);
//        int editNumberMessage = Integer.parseInt(editText.getText().toString());
//        thirdActivityIntent.putExtra("3",editNumberMessage);
        startActivity(thirdActivityIntent);
    }
}
