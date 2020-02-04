package com.example.parkingapp.di;


import com.example.parkingapp.view.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CeibaActivitySubComponent.class})
abstract class CeibaActivityModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<?>
    bindYourAndroidInjectorFactory(CeibaActivitySubComponent.Factory factory);


}
