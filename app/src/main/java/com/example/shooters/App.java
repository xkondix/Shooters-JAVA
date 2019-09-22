package com.example.shooters;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;




public class App extends SurfaceView implements SurfaceHolder.Callback {


    private MainThread thread;
    private Main2Activity main2Activity=null;
    private ArrayList<Red> list;
    private Side side;
    private Paint paint;
    private int pkt,hp;




    App(Context context, Main2Activity main2Activity) {
        super(context);
        this.main2Activity=main2Activity;
        setFocusable(true);
        setConstans();
    }

    public void surfaceCreated(SurfaceHolder holder) {

        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();
    }

    public void surfaceDestroyed(SurfaceHolder holder) {


        while (true) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {

    }


    public Side getSide()
    {
        return side;
    }



    public void setConstans() {
        thread = new MainThread(getHolder(), this);
        getHolder().addCallback(this);

        paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.rgb(22, 155, 222));


        side = new Side(getContext());
        pkt=0;
        hp=5;



    }

    public void setHp()
    {
        hp-=1;
    }

    public Boolean getHp()
    {
        return hp>0;
    }


    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawRGB(255, 255, 255);

        canvas.drawText("hp: "+hp, getWidth()-800, getHeight()-80, paint);

        canvas.drawText("pkt: "+pkt, getWidth()-1000, getHeight()-80, paint);


        for(int i = 0; i<4;i++)
        {
            if (side.getDict().get(i).getEx() == false) {
                canvas.drawBitmap(side.getDict().get(i).getObject(), (int) side.getDict().get(i).myGetX(), (int) side.getDict().get(i).myGetY(), null);
            }
        }

        if(!getHp())
        {
            canvas.drawRGB(255, 255, 255);
            canvas.drawText("GAME OVER: " + pkt, getWidth()/2, getHeight(), paint);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            main2Activity.exit();
        }



    }

    public boolean onTouchEvent(MotionEvent e) {


        switch (e.getAction()) {
            case MotionEvent.ACTION_UP: {

            }
            case MotionEvent.ACTION_MOVE: {

            }
            case MotionEvent.ACTION_DOWN: {

                int x = (int) e.getX();
                int y = (int) e.getY();

                for(int i = 0; i<4;i++)
                {
                    if (x >= side.getDict().get(i).myGetX() && x < (side.getDict().get(i).myGetX()  + side.getDict().get(i).getObject().getWidth())
                            && y >= side.getDict().get(i).myGetY() && y < (side.getDict().get(i).myGetY() + side.getDict().get(i).getObject().getHeight())) {

                        side.getDict().get(i).hit();
                        side.getDict().get(i).setEx();
                        pkt+=side.getDict().get(i).getPkt();
                        side.setDict(i);



                    }
                }




                break;
            }
        }


        return true;
    }


}