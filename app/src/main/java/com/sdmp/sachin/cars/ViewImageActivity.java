package com.sdmp.sachin.cars;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

//Dynamic creation of second Activity

public class ViewImageActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        ImageView imageView = new ImageView(getApplicationContext());
        //gets the id of image clicked
        final int position = intent.getIntExtra("index",0);
        //sets the image to pointed resource
        imageView.setImageResource(intent.getIntExtra(MainActivity.EXTRA_RES_ID,0));
        setContentView(imageView);
        // On click of Image it calls the makers website
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] dealersArray = getResources().getStringArray(R.array.maker_pages);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(dealersArray[position]));
                startActivity(browserIntent);

            }
        });
    }
}
