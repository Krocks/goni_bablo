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
//        dao.saveSession(incomingSession)
//        for (item in incomingSession.items){
//            dao.saveItem(item)
//        }
//        incomingSession.items[0].sessionId = incomingSession.id
//        dao.saveItem(incomingSession.items[0])

        val temSes = dao.getAllSessions()[0]
//        val items = dao.getSessionById(temSes.id)
        temSes.items.add(incomingSession.items[0])
        temSes.items[0].sessionId = temSes.id
        dao.saveItem(temSes.items[0])

        Timber.d(temSes.toString())
    }

    override fun onResume() {
        super.onResume()
    }
}
