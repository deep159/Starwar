package com.example.hi.starwar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hi on 06-04-2017.
 */

public class myadapter extends BaseAdapter {
    Context context;
    ArrayList<String> Aname;
    ArrayList<String> Aheight;
    ArrayList<String> Amass;
    ArrayList<String> Ahaircolor;
    LayoutInflater inflater;

    public myadapter(MainActivity mainActivity, ArrayList<String> namearray, ArrayList<String> heightarray, ArrayList<String> massarray, ArrayList<String> haircolorarray) {
        context=mainActivity;
        Aname=namearray;
        Aheight=heightarray;
        Amass=massarray;
        Ahaircolor=haircolorarray;
        inflater=inflater.from(context);
    }

    @Override
    public int getCount() {
        return Aname.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        TextView mname,mheight,mmass,mhaircolor;
     view=inflater.inflate(R.layout.mylist,null);
        mname=(TextView) view.findViewById(R.id.ename);
        mheight=(TextView) view.findViewById(R.id.eheight);
        mmass=(TextView) view.findViewById(R.id.emass);
        mhaircolor=(TextView) view.findViewById(R.id.ehaircolor);
        mname.setText(Aname.get(position));
        mheight.setText(Aheight.get(position));
        mmass.setText(Amass.get(position));
        mhaircolor.setText(Ahaircolor.get(position));
        return view;
    }
}
