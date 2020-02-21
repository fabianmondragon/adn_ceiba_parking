package com.example.parkingapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class PageObjectParking {

    public static void enterMotorcyclePlate(String plate) {
        fillFields(R.id.editTextMotorcyclePlate, plate);
    }

    public static void enterMotorcycleCylindrical(int cylindrical) {
        fillFields(R.id.editTextMotorcycleCylindrical, "" + cylindrical);
    }

    public static void enterCarPlate(String plate) {
        fillFields(R.id.editTextCarPlate, plate);
    }

    public static void registerMotorcycle() {
        onView(withId(R.id.btnRegister))
                .perform(click())
                .check(matches(isDisplayed()));
    }

    public static void registerCar() {
        onView(withId(R.id.btnRegisterCar))
                .perform(click())
                .check(matches(isDisplayed()));
    }

    public static void billCar() {
        clickOverflowItem(R.id.btnBillCar);
    }

    public static void billMotorcycle() {
        clickOverflowItem(R.id.btnBillMotorcycle);
    }

    private static void fillFields(int resId, String text) {
        onView(withId(resId)).perform(typeText(text));
    }

    private static void clickOverflowItem(int resId) {
        onView(withId(resId))
                .perform(click())
                .check(matches(isDisplayed()));
    }

}
