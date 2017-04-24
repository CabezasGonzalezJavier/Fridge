package com.thedeveloperworldisyours.fridge;

import android.util.Log;

/**
 * Created by javierg on 24/04/2017.
 */

public class ConsoleChat implements Chat {

    public static final String TAG = "ConsoleChat";

    @Override
    public void sendMessage(String message) {
        Log.d(TAG, message);
    }

}
