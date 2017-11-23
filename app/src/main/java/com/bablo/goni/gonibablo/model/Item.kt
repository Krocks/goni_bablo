package com.bablo.goni.gonibablo.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */
//@Entity(tableName = "item")
//data class Item(
//        @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true)val id: Long = 0,
//        @ColumnInfo(name = "item_name") var name: String,
//        @ColumnInfo(name = "item_people") val people: ArrayList<Person> = ArrayList(),
//        @ColumnInfo(name = "item_price") var price: Float,
//        @ColumnInfo(name = "item_payed") var payedBy: ArrayList<Person> = ArrayList()) {
//    fun addPerson(person: Person) {
//        people.add(person)
//    }
//
//    fun removePerson(person: Person) {
//        people.remove(person)
//    }
//
//    override fun hashCode(): Int = 31 * id.hashCode() * name.hashCode() * price.hashCode()
//    override fun toString(): String = "Item " + id + name + price
//}
data class Item(
        val id: Long = 0,
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