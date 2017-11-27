package com.bablo.goni.gonibablo.arch.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.bablo.goni.gonibablo.model.Item
import com.bablo.goni.gonibablo.model.Session

/**
 * Created by Serhii_Bondarenko3 on 21-Nov-17.
 */
@Database(entities = arrayOf(Session::class, Item::class), version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun someDao():SomeDao
}