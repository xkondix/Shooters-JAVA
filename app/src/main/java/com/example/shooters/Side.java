package com.example.shooters;

import android.content.Context;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Side
{


    private static Map<Integer,ImagesBefore> dict;
    private Context context;
    private Random rand;


    public Side(Context context)
    {
        this.context=context;
        dict = new TreeMap<Integer,ImagesBefore>();
        rand = new Random();
        setConstans();


    }

    public  Map<Integer,ImagesBefore> getDict()
    {
        return dict;
    }



    public void setDict(int index) {

        //Class leftUp[] = { Red.class, Blue.class,Brown.class,Green.class,Yellow.class,Orange.class};


        ImagesBefore leftUp[] = {new Red(0,1000,1,-2,context),
                new Blue(0,1000,1,-2,context),
                new Green(0,1000,1,-2,context),
                new Brown(0,1000,1,-2,context),
                new Orange(0,1000,1,-2,context),
                new Yellow(0,1000,1,-2,context)};


        ImagesBefore leftDown[] = {new Red(0,1500,1,-2,context),
                new Blue(0,1500,1,-2,context),
                new Green(0,1500,1,-2,context),
                new Brown(0,1500,1,-2,context),
                new Orange(0,1500,1,-2,context),
                new Yellow(0,1500,1,-2,context)};


        ImagesBefore rightUp[] = {new Red(1000,1000,-1,-2,context),
                new Blue(1000,1000,-1,-2,context),
                new Green(1000,1000,-1,-2,context),
                new Brown(1000,1000,-1,-2,context),
                new Orange(1000,1000,-1,-2,context),
                new Yellow(1000,1000,-1,-2,context)};

        ImagesBefore rightDown[] = {new Red(1000,1500,-1,-2,context),
                new Blue(1000,1500,-1,-2,context),
                new Green(1000,1500,-1,-2,context),
                new Brown(1000,1500,-1,-2,context),
                new Orange(1000,1500,-1,-2,context),
                new Yellow(1000,1500,-1,-2,context)};

        switch(index)
        {
            case 0:
            {


              /*  try {
                    dict.put(index, (ImagesBefore) leftUp[rand.nextInt(6)].getConstructor(Integer.class,Integer.class,Integer.class,Integer.class,Context.class).newInstance(0,1000,1,-2,context));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
               */

                dict.put(index,leftUp[rand.nextInt(6)]);
                dict.get(index).startThread();
                break;
            }

            case 1:
            {
                dict.put(index,leftDown[rand.nextInt(6)]);
                dict.get(index).startThread();


                break;
            }
            case 2:
            {
                dict.put(index,rightUp[rand.nextInt(6)]);
                dict.get(index).startThread();


                break;
            }
            case 3:
            {
                dict.put(index,rightDown[rand.nextInt(6)]);
                dict.get(index).startThread();


                break;
            }
        }

    }


    private void setConstans()
    {
        ImagesBefore leftUp[] = {new Red(0,1000,1,-2,context),
                new Blue(0,1000,1,-2,context),
                new Green(0,1000,1,-2,context),
                new Brown(0,1000,1,-2,context),
                new Orange(0,1000,1,-2,context),
                new Yellow(0,1000,1,-2,context)};

        ImagesBefore leftDown[] = {new Red(0,1500,1,-2,context),
                new Blue(0,1500,1,-2,context),
                new Green(0,1500,1,-2,context),
                new Brown(0,1500,1,-2,context),
                new Orange(0,1500,1,-2,context),
                new Yellow(0,1500,1,-2,context)};


        ImagesBefore rightUp[] = {new Red(1000,1000,-1,-2,context),
                new Blue(1000,1000,-1,-2,context),
                new Green(1000,1000,-1,-2,context),
                new Brown(1000,1000,-1,-2,context),
                new Orange(1000,1000,-1,-2,context),
                new Yellow(1000,1000,-1,-2,context)};

        ImagesBefore rightDown[] = {new Red(1000,1500,-1,-2,context),
                new Blue(1000,1500,-1,-2,context),
                new Green(1000,1500,-1,-2,context),
                new Brown(1000,1500,-1,-2,context),
                new Orange(1000,1500,-1,-2,context),
                new Yellow(1000,1500,-1,-2,context)};


        dict.put(0,leftUp[rand.nextInt(6)]);
        dict.put(1,leftDown[rand.nextInt(6)]);
        dict.put(2,rightUp[rand.nextInt(6)]);
        dict.put(3,rightDown[rand.nextInt(6)]);

        for(int i = 0; i<4;i++)
        {
            dict.get(i).startThread();
        }









    }

}
