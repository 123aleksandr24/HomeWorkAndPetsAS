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

public class HouseholdActivity extends AppCompatActivity {

    ArrayList<String> arrayList4;
    ListView listView4;
    ArrayAdapter<String> arrayAdapter4;
    int chooseItemPosition4;
    private static final String PREFERENCEC4 = "PREFERENCES_INSTRUMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_household);

        arrayList4 = new ArrayList<>();

        SharedPreferences preferences = getSharedPreferences(PREFERENCEC4,MODE_PRIVATE);
        for (int i = 0; i < preferences.getInt("length",0); i++){
            arrayList4.add(preferences.getString(String.valueOf(i), ""));
        }

        listView4 = findViewById(R.id.list_view_instruments);
        arrayAdapter4 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_single_choice,arrayList4);
        listView4.setAdapter(arrayAdapter4);

        listView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                chooseItemPosition4 = i;

            }
        });
    }

    public void buttonAddHousehold(View view) {
        EditText editText = findViewById(R.id.edit_text_instrument);
        String item = editText.getText().toString();
        if(item.equals("")){
            Toast toast = Toast.makeText(this,"Добавьте интсрумент!",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        } else {
            arrayList4.add(item);
            arrayAdapter4.notifyDataSetChanged();
            editText.setText("");
        }
    }

    public void buttonRemoveHousehold(View view) {
        if(arrayList4.isEmpty()){
            Toast toast = Toast.makeText(this,"Cписок пуст!",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        } else {
            arrayList4.remove(chooseItemPosition4);
            arrayAdapter4.notifyDataSetChanged();
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
        String[] items = arrayList4.toArray(new String[0]);
        SharedPreferences preferences = getSharedPreferences(PREFERENCEC4,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        for (int i = 0 ; i < items.length ; i++){
            editor.putString(String.valueOf(i), items[i]);
        }
        editor.putInt("length", items.length);
        editor.apply();
    }
}
