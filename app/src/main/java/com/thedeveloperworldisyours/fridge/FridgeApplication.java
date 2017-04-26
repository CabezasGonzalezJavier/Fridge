package com.thedeveloperworldisyours.fridge;

import android.app.Application;


/**
 * Created by javierg on 25/04/2017.
 */

public class FridgeApplication extends Application {

    FridgeComponent mFridgeComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mFridgeComponent = DaggerFridgeComponent.builder()
                .fridgeModule(new FridgeModule(this)).build();
    }


    public FridgeComponent getFridgeComponent() {
        return mFridgeComponent;
    }
}
