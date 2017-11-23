package com.bablo.goni.gonibablo.di


import android.app.Application
import com.bablo.goni.gonibablo.BuildConfig

import timber.log.Timber

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */

class MyApp : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var graph: AppComponent
    }



    override fun onCreate() {
        super.onCreate()

        graph = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        graph.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
