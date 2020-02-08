package com.example.parkingapp;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context  = getApplicationContext();
    }

    public static Context getAppContext() {
        return BaseApplication.context;
    }



}
