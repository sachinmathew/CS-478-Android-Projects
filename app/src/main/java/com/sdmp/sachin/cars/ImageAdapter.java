package com.sdmp.sachin.cars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


//Gridview adapter for CarImages
class ImageAdapter extends BaseAdapter {
    static final int padding = 8;
    static final int height = 300;
    static final int width = 300;
    Context mContext;
    List<Integer> ids;
    List<String> gridViewString;

    public ImageAdapter(Context c, List<Integer> CarIds, List<String> carNames) {
        mContext = c;
        this.ids = CarIds;
        this.gridViewString = carNames;

    }

    @Override
    public int getCount() {
        return ids.size();
    }

    @Override
    public Object getItem(int position) {
        //return ids.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        //return ids.get(position);
        return 0;
    }

    //sets image and text for each gridcells
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            gridViewAndroid = inflater.inflate(R.layout.gridviewwithname, null);
            ImageView imageViewAndroid = gridViewAndroid.findViewById(R.id.android_gridview_image);
            TextView textViewAndroid = gridViewAndroid.findViewById(R.id.android_gridview_text);
            textViewAndroid.setText(gridViewString.get(position));
            imageViewAndroid.setImageResource(ids.get(position));
        } else gridViewAndroid = convertView;

        return gridViewAndroid;
    }
}
