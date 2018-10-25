package com.sdmp.sachin.cars;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {
    protected static final String EXTRA_RES_ID = "POS";
    ArrayList<Integer> images = new ArrayList<>(Arrays.asList(R.drawable.ferrari, R.drawable.camray, R.drawable.benz,
            R.drawable.audi, R.drawable.bmwsedan, R.drawable.dodge,
            R.drawable.lexus, R.drawable.volkswagen));
    ArrayList<String> names = new ArrayList<>(Arrays.asList("Ferrai", "Toyota Camry", "Benz",
            "Audi", "BMW", "Dodge", "Lexus", "Volkswagen"));


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        GridView gridView = findViewById(R.id.gridView);
         /* resize and load the images. resizing occurs only when
              app loads for the first time and reuses the same reference on subsequent onCreate() calls.
         */
        if (Resizer.resizedList.isEmpty()) {
            Resizer.resizeImages(getApplicationContext(), images);
        }
        //create a new image adpater and   setting it for gridView
        gridView.setAdapter(new ImageAdapter(this, images, names));
        registerForContextMenu(gridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ViewImageActivity.class);
                System.out.print(position);
                intent.putExtra(EXTRA_RES_ID, images.get(position));
                intent.putExtra("index", position);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        // inflate the menu layout for the context menu
        inflater.inflate(R.menu.cars_ctx_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        // get menu itemInformation for selected item
        AdapterView.AdapterContextMenuInfo itemInformation = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        // get the item's Position
        int position = itemInformation.position;
        switch (item.getItemId()) {
            // start CarImageViewActivity using explicit intent
            case R.id.viewImage:
                Intent viewImgIntent = new Intent(MainActivity.this, ViewImageActivity.class);
                viewImgIntent.putExtra(EXTRA_RES_ID, images.get(position));
                startActivity(viewImgIntent);
                return true;
            // start a browser activity to show maker webpage using implicit intent
            case R.id.makerPage:
                String[] dealersArray = getResources().getStringArray(R.array.maker_pages);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(dealersArray[position]));
                startActivity(browserIntent);
                return true;
            // start DealerActivity to list of dealers using explicit intent
            case R.id.carDealers:
                Intent listDealersIntent = new Intent(MainActivity.this, DealerActivity.class);
                listDealersIntent.putExtra(EXTRA_RES_ID, position);
                startActivity(listDealersIntent);
                return true;
            default:
                return super.onContextItemSelected(item);

        }
    }
}
