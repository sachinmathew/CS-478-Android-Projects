package com.sdmp.sachin.cars;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.ArrayList;
import java.util.List;


public class Resizer {

    // width for resized image
    public static final int NEW_WIDTH = 500;
    //height for resized image
    public static final int NEW_HEIGHT = 300;
    // static field to hold the list of resized images
    public static List<Bitmap> resizedList = new ArrayList<>();

    // method to resize the images
    public static void resizeImages(Context mContext, ArrayList<Integer> carImages) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        // set decoded image size scaled down to one-fourth
        options.inSampleSize = 4;

        for (Integer carId : carImages) {
            // convert resource id to bitmap for downsizing image for thumbnails
            Bitmap bm = BitmapFactory.decodeResource(mContext.getResources(), carId, options);
            // resize the decoded image to 500 x 300
            Bitmap resizedBitmap = Bitmap.createScaledBitmap(bm, NEW_WIDTH, NEW_HEIGHT, true);
            resizedList.add(resizedBitmap);

        }
    }
}
