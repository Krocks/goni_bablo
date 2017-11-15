package com.bablo.goni.gonibablo.model

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */
data class Item(val id: String, var name: String, val people: ArrayList<Person>, var price: Float, var payedBy: ArrayList<Person> = ArrayList()) {
    fun addPerson(person: Person) {
        people.add(person)
    }

    fun removePerson(person: Person) {
        people.remove(person)
    }
}