package com.example.shooters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Red extends ImagesBefore {

    private Context c;

    public Red(double x, double y,double dx, double dy, Context context)
    {
        super(x,y,dx,dy,"e1",5,context);
        this.c=context;
    }


    @Override
    int getPkt() {
        return 6;
    }


    @Override
    void hit()
    {
        object = BitmapFactory.decodeResource(c.getResources(), R.drawable.e1d);
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
