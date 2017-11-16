package com.bablo.goni.gonibablo.model

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */
data class Item(
        val id: String = "test",
        var name: String,
        val people: ArrayList<Person> = ArrayList(),
        var price: Float,
        var payedBy: ArrayList<Person> = ArrayList()) {
    fun addPerson(person: Person) {
        people.add(person)
    }

    fun removePerson(person: Person) {
        people.remove(person)
    }

    override fun hashCode(): Int = 31 * id.hashCode() * name.hashCode() * price.hashCode()
    override fun toString(): String = "Item " + id + name + price
}