package com.example.parkingapp.presentation.view;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.example.parkingapp.PageObjectParking;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void registerMotorcycle_DataValid_ShouldShowSuccess() {
        PageObjectParking.enterMotorcyclePlate("LM021");
        PageObjectParking.enterMotorcycleCylindrical(100);
        PageObjectParking.registerMotorcycle();
    }

    @Test
    public void registerCar_DataValid_ShouldShowSuccess() {
        PageObjectParking.enterCarPlate("CLMO21");
        closeSoftKeyboard();
        PageObjectParking.registerCar();
    }

    @Test
    public void calculateCost_WithMotorCycleSaved_ShouldShowNotRegister() {
        PageObjectParking.enterMotorcyclePlate("100");
        PageObjectParking.billMotorcycle();
    }

    @Test
    public void calculateCost_WithCarSaved_ShouldShowCero() {
        PageObjectParking.enterCarPlate("CLMO21");
        closeSoftKeyboard();
        PageObjectParking.billCar();
    }

}