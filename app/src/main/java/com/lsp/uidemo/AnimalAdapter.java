package com.lsp.uidemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by lsp.
 * Date: 2021-5-28
 */
public class AnimalAdapter extends ArrayAdapter {

    private int resourceId;


    public AnimalAdapter(@NonNull Context context, int textViewResourceId, List<Animal> obj) {
        super(context, textViewResourceId, obj);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 获取当前实例
        Animal animal = (Animal) getItem(position);
//
//        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
//        ImageView imageView = view.findViewById(R.id.animal_image);
//        TextView textView = view.findViewById(R.id.animal_name);
//        imageView.setImageResource(animal.getImageId());
//        textView.setText(animal.getName());

/**
 * getView()每次都将布局重新加载了一遍，需要对listview进行优化
 */

        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.animalImage = view.findViewById(R.id.animal_image);
            viewHolder.animalName = view.findViewById(R.id.animal_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.animalName.setText(animal.getName());
        viewHolder.animalImage.setImageResource(animal.getImageId());
        return view;
    }

    class ViewHolder {
        ImageView animalImage;
        TextView animalName;
    }


}
