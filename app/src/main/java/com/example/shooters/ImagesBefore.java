package com.example.shooters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;



public abstract class ImagesBefore
{

    private double x,y,dx,dy;
    private String path;
    private int sleep;
    Bitmap object;
    private boolean ex = false;
    MyThread thread;
    private Context c;
    private Boolean game = false;



    ImagesBefore(double x, double y,double dx, double dy, String path,int sleep, Context context)
    {
        this.c=context;
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
        this.path=path;
        this.sleep=sleep;
        setConstans();
        thread = new MyThread();



    }



    public void setConstans()
    {
        switch(path)
        {
            case "e1":
            {
                object = BitmapFactory.decodeResource(c.getResources(), R.drawable.e1);
                break;
            }

            case "e2":
            {
                object = BitmapFactory.decodeResource(c.getResources(), R.drawable.e2);
                break;
            }

            case "e3":
            {
                object = BitmapFactory.decodeResource(c.getResources(), R.drawable.e3);
                break;
            }

            case "e4":
            {
                object = BitmapFactory.decodeResource(c.getResources(), R.drawable.e4);
                break;
            }

            case "e5":
            {
                object = BitmapFactory.decodeResource(c.getResources(), R.drawable.e5);
                break;

            }

            case "e6":
            {
                object = BitmapFactory.decodeResource(c.getResources(), R.drawable.e6);
                break;
            }
        }

        object = Bitmap.createScaledBitmap(object,
                 200, 200, false);
    }

    abstract int getPkt();


    double myGetX()
    {
         return x;
    }

    double myGetY()
    {
        return y;
    }


    public void setGame(Boolean g)
    {
        this.game=g;
    }

    public Boolean getGame()
    {
        return game;
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

    public void startThread()
    {
        setGame(true);
        thread.start();
    }





    class MyThread extends Thread
    {

        MyThread()
        {
            super();
        }

        public void run()
        {
            while(getGame())
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
        return object;
    }


    public Boolean getEx()
    {
        return ex;
    }

    public void setEx()
    {
        ex=true;
    }

    abstract void hit();


}
