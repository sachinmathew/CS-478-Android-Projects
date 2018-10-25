package com.sdmp.sachin.cars;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

//Activity to display list of activities
public class DealerActivity extends Activity {

    List<List<Dealer>> dealers = new ArrayList<List<Dealer>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            // parse and load the dealer data
            loadDealers();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Setting UI
        setContentView(R.layout.activity_list_view);
        ListView listView = (ListView) findViewById(R.id.listView);
        Intent intent = getIntent();
        // get position of gridItem
        int gridPos = intent.getIntExtra(MainActivity.EXTRA_RES_ID, 0);
        // set the adapter fot list view
        listView.setAdapter(new DealerListAdapter(this, dealers.get(gridPos)));


    }

    private void loadDealers() throws JSONException {
        // get list of all dealers for all type of cars
        String[] dealersArray = getResources().getStringArray(R.array.dealers);
        String dealerName;
        String dealerAddress;
        // for each car type
        for (int j = 0; j < dealersArray.length; j++) {
            // get the JSON object by parsing the string
            JSONObject brandJson = new JSONObject(dealersArray[j]);
            // get all the dealers for that car type
            JSONArray brandDealerJsonList = brandJson.getJSONArray("dealerList");
            List<Dealer> dealerList = new ArrayList<>();
            // for each dealer we parse dealerName and dealerAddress
            for (int k = 0; k < brandDealerJsonList.length(); k++) {
                JSONObject jo = brandDealerJsonList.getJSONObject(k);
                dealerName = jo.getString("name");
                 dealerAddress = jo.getString("address");
                // create dealer with the dealerName and dealerAddress
                Dealer carDealer = new Dealer(dealerName, dealerAddress);
                // add Dealer to dealerList
                dealerList.add(carDealer);

            }
            dealers.add(dealerList);
        }

    }

}
