package com.bablo.goni.gonibablo;


import android.app.Application;

import timber.log.Timber;

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
