package com.mycompany.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapplication.R;
import com.mycompany.myapplication.dto.Animal;
import com.mycompany.myapplication.dto.Food;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalListFragment extends Fragment {
    private static final String TAG = AnimalListFragment.class.getSimpleName();

    private ListView listView;
    private List<Animal> list = new ArrayList<>();
    private ItemAdapter itemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listView = (ListView) inflater.inflate(R.layout.fragment_animal_list, container, false);
        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(itemClickListener);
        return listView;
    }

    @Override
    public void onStart() {
        super.onStart();
        for(int i=1; i<=14; i++) {
            Animal animal = new Animal();
            animal.setAno(i);
            animal.setAname("동물" + i);
            animal.setAphoto(getResources().getIdentifier("animal"+i, "drawable", getContext().getPackageName()));
            animal.setAdate(new Date());
            animal.setAdesc("동물원에 갑시다 에버렌드 사파리가 좋은 것 같습니다 서울대공원 원숭이도 귀엽습니다");
            addItem(animal);
        }
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Animal animal = (Animal) itemAdapter.getItem(position);
        }
    };

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
