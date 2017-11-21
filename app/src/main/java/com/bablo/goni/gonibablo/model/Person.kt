package com.bablo.goni.gonibablo.model

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */
data class Person(val id: Long = 0, var name: String, val items: ArrayList<Item>, private var owe: Float = 0f) {
    fun addItem(item: Item) = items.add(item)
    fun removeItem(item: Item) = items.remove(item)

    fun givenMoney(money: Float) {//here for possible modification and one entry point
        owe -= money
    }

    fun wastedMoney(money: Float) {
        owe += money
    }

    override fun hashCode(): Int = 37 * id.hashCode() * name.hashCode() * owe.hashCode()
    override fun toString(): String = "Person $id $name $owe"
}