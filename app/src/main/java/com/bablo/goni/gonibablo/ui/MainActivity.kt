package com.bablo.goni.gonibablo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bablo.goni.gonibablo.R
import com.bablo.goni.gonibablo.arch.room.AppDataBase
import com.bablo.goni.gonibablo.arch.room.SomeDao
import com.bablo.goni.gonibablo.di.MyApp
import com.bablo.goni.gonibablo.model.Session
import com.bablo.goni.gonibablo.model.getSampleSession
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var appDatabase : AppDataBase
    @Inject lateinit var dao : SomeDao
    @Inject lateinit var app : MyApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        MyApp.graph.inject(this)
        val incomingSession = getSampleSession()
        dao.saveSession(incomingSession)

        val temSes = dao.getAllSessions()
        Timber.d(temSes.toString())
    }

    override fun onResume() {
        super.onResume()
    }
}
