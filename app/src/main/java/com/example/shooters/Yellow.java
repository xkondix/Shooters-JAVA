package com.example.shooters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Yellow extends ImagesBefore {

    private Context c;

    public Yellow(double x, double y,double dx, double dy, Context context)
    {
        super(x,y,dx,dy,"e4",20,context);
        this.c = context;
    }


    @Override
    int getPkt() {
        return 3;
    }



    @Override
    void hit() {

        object = BitmapFactory.decodeResource(c.getResources(), R.drawable.e4d);
        object = Bitmap.createScaledBitmap(object,
                200, 200, false);

        this.setGame(false);


        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}