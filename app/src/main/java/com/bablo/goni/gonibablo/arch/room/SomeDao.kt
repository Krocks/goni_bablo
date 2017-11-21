package com.bablo.goni.gonibablo.arch.room

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.bablo.goni.gonibablo.model.Session

/**
 * Created by Serhii_Bondarenko3 on 21-Nov-17.
 */
@Dao interface SomeDao{

    @Query("select * from session")
    fun getAllSessions():List<Session>

//    @Query("select * from session where id = :p0") //maybe still exists
    @Query("select * from session where id = :id")
    fun getSessionById(id : Long) : Session

    @Insert(onConflict = REPLACE)
    fun saveSession(session: Session)

    @Update(onConflict = REPLACE)
    fun updateSession(session: Session)

    @Delete
    fun deleteSession(session: Session)
}