package com.lsp.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewShow extends AppCompatActivity {

    private List<Animal> mAnimalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_show);

        initview();

        AnimalAdapter adapter = new AnimalAdapter(this, R.layout.lv_item, mAnimalList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private void initview() {

        for (int i = 0; i < 3; i++) {
            Animal apple = new Animal("鸭子", R.drawable.little_animal_01);
            mAnimalList.add(apple);
            Animal banana = new Animal("红牛", R.drawable.little_animal_03);
            mAnimalList.add(banana);
            Animal orange = new Animal("小猫", R.drawable.little_animal_05);
            mAnimalList.add(orange);
            Animal watermelon = new Animal("花牛", R.drawable.little_animal_07);
            mAnimalList.add(watermelon);
            Animal pear = new Animal("小狗", R.drawable.little_animal_09);
            mAnimalList.add(pear);
            Animal grape = new Animal("大嘴鸭", R.drawable.little_animal_11);
            mAnimalList.add(grape);
            Animal pineapple = new Animal("大象", R.drawable.little_animal_13);
            mAnimalList.add(pineapple);
            Animal strawberry = new Animal("小鱼", R.drawable.little_animal_15);
            mAnimalList.add(strawberry);
            Animal cherry = new Animal("小马", R.drawable.little_animal_17);
            mAnimalList.add(cherry);
            Animal mango = new Animal("七星瓢虫", R.drawable.little_animal_19);
            mAnimalList.add(mango);
        }
    }


}