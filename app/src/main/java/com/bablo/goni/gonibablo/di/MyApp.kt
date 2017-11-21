package com.bablo.goni.gonibablo.di


import android.app.Application
import com.bablo.goni.gonibablo.BuildConfig

import timber.log.Timber

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */

class MyApp : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
