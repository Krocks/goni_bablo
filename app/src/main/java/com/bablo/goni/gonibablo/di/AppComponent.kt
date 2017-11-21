package com.bablo.goni.gonibablo.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by Serhii_Bondarenko3 on 21-Nov-17.
 */
@Singleton
@Component (modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app : MyApp)
}