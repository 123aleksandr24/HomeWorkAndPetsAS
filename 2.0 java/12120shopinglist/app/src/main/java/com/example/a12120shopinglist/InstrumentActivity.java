package com.example.a12120shopinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InstrumentActivity extends AppCompatActivity {

    ArrayList<String> arrayList3;
    ListView listView3;
    ArrayAdapter<String> arrayAdapter3;
    int chooseItemPosition3;
    private static final String PREFERENCEC3 = "PREFERENCES_PRODUCTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument);

        arrayList3 = new ArrayList<>();

        SharedPreferences preferences = getSharedPreferences(PREFERENCEC3,MODE_PRIVATE);
        for (int i = 0; i < preferences.getInt("length",0); i++){
            arrayList3.add(preferences.getString(String.valueOf(i), ""));
        }

        listView3 = findViewById(R.id.list_view_products);
        arrayAdapter3 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_single_choice,arrayList3);
        listView3.setAdapter(arrayAdapter3);

        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                chooseItemPosition3 = i;

            }
        });
    }

    public void buttonAddInstrument(View view) {
        EditText editText = findViewById(R.id.edit_text_instrument);
        String item = editText.getText().toString();
        if(item.equals("")){
            Toast toast = Toast.makeText(this,"Добавьте инструмент!",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        } else {
            arrayList3.add(item);
            arrayAdapter3.notifyDataSetChanged();
            editText.setText("");
        }
    }

    public void buttonRemoveInstrument(View view) {
        if(arrayList3.isEmpty()){
            Toast toast = Toast.makeText(this,"Cписок пуст!",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        } else {
            arrayList3.remove(chooseItemPosition3);
            arrayAdapter3.notifyDataSetChanged();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onSaveData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        onSaveData();
    }

    void onSaveData (){
        String[] items = arrayList3.toArray(new String[0]);
        SharedPreferences preferences = getSharedPreferences(PREFERENCEC3,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        for (int i = 0 ; i < items.length ; i++){
            editor.putString(String.valueOf(i), items[i]);
        }
        editor.putInt("length", items.length);
        editor.apply();
    }
}
