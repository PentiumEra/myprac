package com.example.myannotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther linghailong
 * created at 2019/1/20
 * @duscribe:
 */
public class Constructors {

    {
        try {
            Class clazz = Class.forName("com.example.myannotation.Student");
            try {
               Constructor constructor=clazz.getDeclaredConstructor(char.class);
                try {
                    Object obj=constructor.newInstance("男");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
