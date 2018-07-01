package com.krito.io.botolat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.krito.io.botolat.R;
import com.krito.io.botolat.model.Champoinship;

/**
 * Created by Goda on 30/06/2018.
 */

public class ChampionshipAdapter extends BaseAdapter {
    Context context;
    String[] test;
    public ChampionshipAdapter(Context context,String [] test) {
        this.context = context;
        this.test=test;
    }

    @Override
    public int getCount() {
        return test.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            grid = new View(context);
            grid = inflater.inflate(R.layout.champs_item_row, null);
            TextView textView = grid.findViewById(R.id.txt_champ_name);
            textView.setText(test[position]);
        } else {
            grid = (View) view;
        }
        return grid;
    }
}
