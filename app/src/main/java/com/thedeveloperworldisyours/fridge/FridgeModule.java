package com.thedeveloperworldisyours.fridge;

import com.thedeveloperworldisyours.fridge.chat.Chat;
import com.thedeveloperworldisyours.fridge.chat.ConsoleChat;

import dagger.Module;
import dagger.Provides;

/**
 * Created by javierg on 25/04/2017.
 */
@Module
public class FridgeModule {
    FridgeApplication fridgeApplication;

    public FridgeModule(FridgeApplication application) {
        this.fridgeApplication = fridgeApplication;
    }

    @Provides
    public Chat provideChat() {
        return new ConsoleChat();
    }
}
