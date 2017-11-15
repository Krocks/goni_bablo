package com.bablo.goni.gonibablo.model

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */
data class Person(val id: String, var name: String, val items: ArrayList<Item>, var owe: Float = 0f) {
    fun addItem(item: Item) = items.add(item)
    fun removeItem(item: Item) = items.remove(item)
}