package com.bablo.goni.gonibablo.di

import android.arch.persistence.room.Room
import android.content.Context
import com.bablo.goni.gonibablo.arch.room.AppDataBase
import com.bablo.goni.gonibablo.arch.room.SomeDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Serhii_Bondarenko3 on 21-Nov-17.
 */
@Module class AppModule (val app : MyApp){
    @Provides @Singleton
    fun provideApplication() = app

    @Provides @Singleton
    fun provideDataBase(context: Context) : AppDataBase = Room.databaseBuilder(context, AppDataBase::class.java, "db_name").allowMainThreadQueries().build()

    @Provides @Singleton
    fun provideDao (dataBase: AppDataBase) : SomeDao = dataBase.someDao()
}