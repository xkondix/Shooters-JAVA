package com.example.shooters;

import android.content.Context;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Side
{


    private static Map<Integer,Ememesy> dict;
    private Context context;
    private Random rand;
    private Ememesy leftUp,leftDown,rightDown,rightUp;
    private Thread thread;
    private ExecutorService executor;


    public Side(Context context)
    {
        this.context=context;
        dict = new TreeMap<Integer,Ememesy>();
        setConstans();


    }

    public  Map<Integer,Ememesy> getDict()
    {
        return dict;
    }



    public void setDict(int index) {

        switch(index)
        {
            case 0:
            {


              /*  try {
                    dict.put(index, (ImagesBefore) leftUp[rand.nextInt(6)].getConstructor(Integer.class,Integer.class,Integer.class,Integer.class,Context.class).newInstance(0,1000,1,-2,context));

               */
                leftUp.newImage(-150,1500);
                break;
            }

            case 1:
            {
                leftDown.newImage(-150,1000);


                break;
            }
            case 2:
            {
                rightUp.newImage(1100,1500);


                break;
            }
            case 3:
            {
                rightDown.newImage(1100,1000);


                break;
            }
        }

    }


    private void setConstans()
    {

        rightDown = new Ememesy(1100,1000,-1,-2,context);
        leftUp = new Ememesy(-50,1500,1,-2,context);
        leftDown = new Ememesy(-50,1000,1,-2,context);
        rightUp = new Ememesy(1100,1500,-1,-2,context);

        dict.put(0,leftUp);
        dict.put(1,leftDown);
        dict.put(2,rightUp);
        dict.put(3,rightDown);


         executor = Executors.newFixedThreadPool(4);

            Runnable emesmes = rightDown.new MyThread();
            executor.execute(emesmes);
            Runnable emesmes1 = leftUp.new MyThread();
            executor.execute(emesmes1);
            Runnable emesmes2 = leftDown.new MyThread();
            executor.execute(emesmes2);
            Runnable emesmes3 = rightUp.new MyThread();
            executor.execute(emesmes3);
        }


        public ExecutorService getExecutor()
        {
            return executor;
        }



    }


