package com.example.parkingapp.di;


import com.example.parkingapp.view.MainActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent (modules = {CeibaActivitySubModule.class})
public interface CeibaActivitySubComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {}
}
