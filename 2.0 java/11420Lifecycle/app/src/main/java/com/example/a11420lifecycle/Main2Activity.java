package com.example.a11420lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toast toast = Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast toast = Toast.makeText(this,"onStart", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,200);
        toast.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast toast = Toast.makeText(this,"onStop", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,600);
        toast.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast toast = Toast.makeText(this,"onRestart", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,450);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast toast = Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,950);
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast toast = Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,350);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast toast = Toast.makeText(this,"onCreate", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,650);
        toast.show();
    }

    public void onOpenFirstActivity(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
