package com.example.administrator.mvvmtest;

import android.app.Application;

/**
 * Created by Administrator on 2016/10/31.
 */

public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }

   public static MyApplication getContext() {
       return instance;
   }
}
