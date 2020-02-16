package com.example.parkingapp.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    public final Application application;

    public AppModule(Application application) {this.application = application;}

    @Provides
    @Singleton
    public Application application (){return  application;}

}
