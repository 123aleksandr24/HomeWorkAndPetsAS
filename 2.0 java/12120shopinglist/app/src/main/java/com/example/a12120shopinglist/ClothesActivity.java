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

public class ClothesActivity extends AppCompatActivity {

    ArrayList<String> arrayList2;
    ListView listView2;
    ArrayAdapter<String> arrayAdapter2;
    int chooseItemPosition2;
    private static final String PREFERENCEC2 = "PREFERENCES_CLOTHES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);

        arrayList2 = new ArrayList<>();

        SharedPreferences preferences = getSharedPreferences(PREFERENCEC2,MODE_PRIVATE);
        for (int i = 0; i < preferences.getInt("length",0); i++){
            arrayList2.add(preferences.getString(String.valueOf(i), ""));
        }

        listView2 = findViewById(R.id.list_view_clothes);
        arrayAdapter2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList2);
        listView2.setAdapter(arrayAdapter2);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                chooseItemPosition2 = i;

            }
        });
    }

    public void buttonAddClothes(View view) {
        EditText editText = findViewById(R.id.edit_text_clothes);
        String item = editText.getText().toString();
        if(item.equals("")){
            Toast toast = Toast.makeText(this,"Добавьте одежду!",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        } else {
            arrayList2.add(item);
            arrayAdapter2.notifyDataSetChanged();
            editText.setText("");
        }
    }

    public void buttonRemoveClothes(View view) {
        if(arrayList2.isEmpty()){
            Toast toast = Toast.makeText(this,"Cписок пуст!",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        } else {
            arrayList2.remove(0);
            arrayAdapter2.notifyDataSetChanged();
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
        String[] items = arrayList2.toArray(new String[0]);
        SharedPreferences preferences = getSharedPreferences(PREFERENCEC2,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        for (int i = 0 ; i < items.length ; i++){
            editor.putString(String.valueOf(i), items[i]);
        }
        editor.putInt("length", items.length);
        editor.apply();
    }


}
