package com.example.a10120ladaresourseexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }

    public void onChoose(View view) {
        Spinner spinnercar = findViewById(R.id.spinner);
        String choosenCar = String.valueOf(spinnercar.getSelectedItem());
        switch (choosenCar) {
            case "Granta": {
                Intent intent = new Intent(this, LadaGrantaActivity.class);
                startActivity(intent);
                break;
            }
            case "Priora": {
                Intent intent = new Intent(this, LadaPrioraActivity.class);
                startActivity(intent);
                break;
            }
            case "Vesta": {
                Intent intent = new Intent(this, LadaVestaActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
