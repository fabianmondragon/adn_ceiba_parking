package com.example.parkingapp;

import android.app.Application;
import android.content.Context;

import com.example.parkingapp.di.AppModule;
import com.example.parkingapp.di.ApplicationComponent;
import com.example.parkingapp.di.DaggerApplicationComponent;
import com.example.parkingapp.di.DomainModule;

public class BaseApplication extends Application {

    public static Context context;
    public  ApplicationComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();

        appComponent = DaggerApplicationComponent
                .builder()
                .domainModule(new DomainModule())
                .appModule(new AppModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }

    public static Context getAppContext() {
        return BaseApplication.context;
    }

}
