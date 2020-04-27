package com.example.a83layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMyButton(View view){
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        EditText editText = findViewById(R.id.myEditText);

        String textFromEditText = editText.getText().toString();
        textView.setText(textFromEditText);

        Spinner spinner = findViewById(R.id.name);
        textView2.setText((CharSequence) spinner);

        Spinner spinner2 = findViewById(R.id.group);
        textView3.setText((CharSequence) spinner2);
    }
}
