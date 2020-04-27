package com.example.linerlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClicMyButton(View view) {
        TextView textView = findViewById(R.id.myTextView);
        EditText editText = findViewById(R.id.myEditText);

        String textFromEditText = editText.getText().toString();

        textView.setText(textFromEditText);
    }

    public void onClickMyToggleButton(View view) {
        TextView textView = findViewById(R.id.myTextView);
        boolean onOrOff = ((ToggleButton)view).isChecked();

        if(onOrOff) {
            textView.setText("Текст в комнате включен");
        } else {
            textView.setText("Свет в комнате выключен");
        }
    }

    public void onClickMySwitch(View view) {
        TextView textView = findViewById(R.id.myTextView);
        boolean onOrOff = ((Switch)view).isChecked();

        if(onOrOff) {
            textView.setText("Текст в комнате включен");
        } else {
            textView.setText("Свет в комнате выключен");
        }
    }

    public void onClickMyCheckBox(View view) {
        TextView textView = findViewById(R.id.myTextView);
        textView.setText("Вы ознакомились с условиями соглашения");
    }

    public void onClickMyRadiogroup1(View view) {
        TextView textView = findViewById(R.id.myTextView);
        textView.setText("Это действительно круто");
    }

    public void onClickMyRadiogroup2(View view) {
        TextView textView = findViewById(R.id.myTextView);
        textView.setText("Вы не правы! Это реально прост! ");
    }

    public void onClickMyImageButton(View view) {
        TextView textView = findViewById(R.id.myTextView);
        textView.setText("Прикольная штука этот ImageButton");
    }


}

