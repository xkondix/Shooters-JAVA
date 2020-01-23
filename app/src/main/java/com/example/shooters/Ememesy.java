package com.example.shooters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.util.*;

import static java.lang.Thread.sleep;

public class Ememesy
{

    private double x,y,dx,dy;
    private int sleep,number,pkt;
    private Bitmap emes;
    private Context c;


    Ememesy(double x, double y,double dx, double dy, Context context)
    {
        this.c=context;
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
        setConstans();


    }


    public void setConstans()
    {

        this.number=new Random().nextInt(6);


        switch(number)
        {
            case 0:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e1);
                this.pkt=1;
                this.sleep=15;
                break;
            }

            case 1:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e2);
                this.pkt=2;
                this.sleep=10;
                break;
            }

            case 2:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e3);
                this.pkt=3;
                this.sleep=8;
                break;
            }

            case 3:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e4);
                this.pkt=4;
                this.sleep=6;
                break;
            }

            case 4:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e5);
                this.pkt=5;
                this.sleep=3;
                break;

            }

            case 5:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e6);
                this.pkt=6;
                this.sleep=1;
                break;
            }
        }

        this.emes = Bitmap.createScaledBitmap(this.emes,
                200, 200, false);
    }

     int getPkt() {
         return this.pkt;
     }


    double myGetX()
    {
        return x;
    }

    double myGetY()
    {
        return y;
    }

    double getDx()
    {
        return dx;
    }

    double getDy()
    {
        return dy;
    }


    void setDx(double dx)
    {
        this.dx=dx;
    }

    void setDy(double dy)
    {
        this.dy=dy;
    }




    public boolean miss()
    {
        if(myGetY() < -150)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    void motion()
    {
        this.x=x+dx;
        this.y=y+dy;
    }


    class MyThread implements Runnable
    {

        MyThread()
        {
            super();
        }

        public void run()
        {
            while(true)
            {
                motion();
                try {
                    sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Bitmap getObject()
    {
        return emes;
    }


    void hit() {


      /*  switch(number)
        {
            case 0:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e1d).createScaledBitmap(this.emes,
                        200, 200, false);;
                break;
            }

            case 1:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e2d).createScaledBitmap(this.emes,
                        200, 200, false);;
                break;
            }

            case 2:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e3d).createScaledBitmap(this.emes,
                        200, 200, false);;
                break;
            }

            case 3:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e4d).createScaledBitmap(this.emes,
                        200, 200, false);;
                this.pkt=4;
                break;
            }

            case 4:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e5d).createScaledBitmap(this.emes,
                    200, 200, false);;
                break;

            }

            case 5:
            {
                this.emes = BitmapFactory.decodeResource(c.getResources(), R.drawable.e6d).createScaledBitmap(this.emes,
                    200, 200, false);;
                break;
            }
        }

        this.emes = Bitmap.createScaledBitmap(this.emes,
                200, 200, false);


*/


    }

    public void newImage(double x, double y) {

        this.x=x;
        this.y=y;
        setConstans();

    }






    }


