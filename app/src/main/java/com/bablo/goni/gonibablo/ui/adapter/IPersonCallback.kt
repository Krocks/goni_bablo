package com.bablo.goni.gonibablo.ui.adapter

import com.bablo.goni.gonibablo.model.Person

/**
 * Created by Serhii_Bondarenko3 on 14-Nov-17.
 */
interface IPersonCallback {
    fun addPerson()
    fun selectPerson(person: Person)
}