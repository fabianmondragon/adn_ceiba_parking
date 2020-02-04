package com.example.parkingapp.di;


import com.example.parkingapp.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component (modules = {AndroidSupportInjectionModule.class,CeibaActivityModule.class, CeibaActivitySubModule.class, ViewModeModule.class})
public interface CeibaComponent {

    void inject(BaseApplication yourApplication);
    void inject(MainActivity mainActivity);


}
