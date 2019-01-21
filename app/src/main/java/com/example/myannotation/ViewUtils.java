package com.example.myannotation;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * @Auther linghailong
 * created at 2019/1/21
 * @duscribe:
 */
public class ViewUtils {
    public static void injext(Activity activity){
        /*1. 获取所有的属性*/
        Field[] fields=activity.getClass().getDeclaredFields();
        for(Field field:fields){
            /*2. 过滤关于ViewByid的属性*/
           ViewById viewById=field.getAnnotation(ViewById.class);
            if (viewById!=null){
                /*3. findViewById*/
                View view=activity.findViewById(viewById.id());
                /*4. 反射注入*/
                field.setAccessible(true);
                /*activity:属性所在类，view:属性所在值*/
                try {
                    field.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
