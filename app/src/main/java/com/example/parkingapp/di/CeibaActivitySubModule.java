package com.example.parkingapp.di;

import com.example.parkingapp.view.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class CeibaActivitySubModule {

    @Provides
    MainActivity provideMainView(MainActivity mainActivity){
        return mainActivity;
    }


}
