package com.bablo.goni.gonibablo.arch

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.bablo.goni.gonibablo.model.Item
import com.bablo.goni.gonibablo.model.Person
import com.bablo.goni.gonibablo.model.Session

/**
 * Created by Serhii_Bondarenko3 on 20-Nov-17.
 */
class SessionViewModel(application: Application) : AndroidViewModel(application) {
    private val sessionLiveData = MutableLiveData<Session>()
    //    private val session
//    fun connect(person: Person, item: Item) {
//        person.addItem(item)
//        item.addPerson(person)
//    }
}