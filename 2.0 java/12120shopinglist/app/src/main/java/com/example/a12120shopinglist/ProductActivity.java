package com.example.a12120shopinglist;

import androidx.annotation.NonNull;
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

public class ProductActivity extends AppCompatActivity {
// обязательно ли каждый раз в новой актичности создавать инкрементные или просто другие значения не похожие на значение предыдущей активности -
// arrayAdapter2 chooseItemPosition arrayList2 listView2 PREFERENCEC  или этого значения  editor.putInt("length", items.length);
//      simple_list_item_single_choice (это просто системный выбор типо "match_parent" ?)
    ArrayList<String> arrayList;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    int chooseItemPosition;
    private static final String PREFERENCEC = "PREFERENCES_PRODUCTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        arrayList = new ArrayList<>();

        SharedPreferences preferences = getSharedPreferences(PREFERENCEC,MODE_PRIVATE);
        for (int i = 0; i < preferences.getInt("length",0); i++){
            arrayList.add(preferences.getString(String.valueOf(i), ""));
        }

        listView = findViewById(R.id.list_view_products);
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_single_choice,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                chooseItemPosition = i;

            }
        });
    }

    public void buttonAdd(View view) {
        EditText  editText = findViewById(R.id.edit_text_products);
        String item = editText.getText().toString();
        if(item.equals("")){
            Toast toast = Toast.makeText(this,"Добавьте покупку!",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        } else {
            arrayList.add(item);
            arrayAdapter.notifyDataSetChanged();
            editText.setText("");
        }
    }

    public void buttonRemove(View view) {
        if(arrayList.isEmpty()){
            Toast toast = Toast.makeText(this,"Cписок пуст!",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        } else {
            arrayList.remove(chooseItemPosition);
            arrayAdapter.notifyDataSetChanged();
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
        String[] items = arrayList.toArray(new String[0]);
        SharedPreferences preferences = getSharedPreferences(PREFERENCEC,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        for (int i = 0 ; i < items.length ; i++){
            editor.putString(String.valueOf(i), items[i]);
        }
        editor.putInt("length", items.length);
        editor.apply();
    }
}
