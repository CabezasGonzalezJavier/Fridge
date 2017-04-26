package com.thedeveloperworldisyours.fridge;

import com.thedeveloperworldisyours.fridge.customer.CustomerActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by javierg on 25/04/2017.
 */
@Singleton
@Component(modules = FridgeModule.class)
public interface FridgeComponent {

    void inject(CustomerActivity customerActivity);
}
