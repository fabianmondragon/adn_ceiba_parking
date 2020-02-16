package com.example.parkingapp.domain.model;

public class CylindricalRules {

    private int motorcycleCylindrical;
    private int state;

    public CylindricalRules(int motorcycleCylindrical, int state) {
        this.motorcycleCylindrical = motorcycleCylindrical;
        this.state = state;
    }

    public CylindricalRules(int motorcycleCylindrical) {
        this.motorcycleCylindrical = motorcycleCylindrical;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCilindrage() {
        return motorcycleCylindrical;
    }

}
