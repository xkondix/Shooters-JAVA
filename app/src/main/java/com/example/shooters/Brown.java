package com.example.shooters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Brown extends ImagesBefore {


    private Context c;

    public Brown(double x, double y,double dx, double dy, Context context)
    {
        super(x,y,dx,dy,"e6",30,context);
        this.c=context;
    }


    @Override
    int getPkt() {
        return 1;
    }

    @Override
    void hit() {

        object = BitmapFactory.decodeResource(c.getResources(), R.drawable.e6d);
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