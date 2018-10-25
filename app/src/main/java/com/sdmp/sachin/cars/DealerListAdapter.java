package com.sdmp.sachin.cars;

import android.content.Context;
import android.view.LayoutInflater;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


//list adapter for Dealer list view


public class DealerListAdapter extends BaseAdapter {


    private Context context;
    private List<Dealer> dealers;

    public DealerListAdapter(Context c, List<Dealer> dealers) {
        context = c;
        this.dealers = dealers;

    }

    @Override
    public int getCount() {

        return dealers.size();
    }

    @Override
    public Object getItem(int position) {

        return dealers.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem;
        // recycle existing views
        if (convertView == null) {
            // get the layout inflater
            LayoutInflater inflater = LayoutInflater.from(context);
            // inflate the list item view
            listItem = inflater.inflate(R.layout.list_item_view, parent, false);
        } else {
            listItem = convertView;
        }
        // get  reference for name text view
        TextView nameView = (TextView) listItem.findViewById(R.id.dealer_name);
        // get for reference for address text view
        TextView addressView = (TextView) listItem.findViewById(R.id.dealer_address);
        //set text with dealer name at respective position
        nameView.setText(dealers.get(position).getName());
        //set text with dealer address at respective position
        addressView.setText(dealers.get(position).getAddress());
        return listItem;
    }
}
