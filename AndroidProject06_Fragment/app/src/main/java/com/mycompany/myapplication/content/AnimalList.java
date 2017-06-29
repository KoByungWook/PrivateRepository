package com.mycompany.myapplication.content;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.Animal;
import com.mycompany.myapplication.dto.Food;

import java.util.ArrayList;
import java.util.List;

public class AnimalList extends LinearLayout {
    private ListView listView;
    private List<Animal> list = new ArrayList<>();
    private ItemAdapter itemAdapter;

    public AnimalList(Context context) {
        super(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        listView = (ListView) inflater.inflate(R.layout.animal_list, null);

        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);

        addView(listView);
    }

    class ItemAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return list.get(position).getAno();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.animal_item, null);
            }
            ImageView aphoto = (ImageView) convertView.findViewById(R.id.aphoto);
            TextView aname = (TextView) convertView.findViewById(R.id.aname);
            TextView adate = (TextView) convertView.findViewById(R.id.adate);
            TextView adesc = (TextView) convertView.findViewById(R.id.adesc);

            Animal animal = list.get(position);
            aphoto.setImageResource(animal.getAphoto());
            aname.setText(animal.getAname());
            adate.setText(String.valueOf(animal.getAdate()));
            adesc.setText(animal.getAdesc());
            return convertView;
        }
    }

    public void addItem(Animal item) {
        list.add(item);
        itemAdapter.notifyDataSetChanged();
    }

    public void removeItem(Animal item) {
        list.remove(item);
        itemAdapter.notifyDataSetChanged();
    }
}
