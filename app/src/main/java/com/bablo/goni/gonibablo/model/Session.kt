package com.bablo.goni.gonibablo.model

import android.arch.persistence.room.*
import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */
val MAX = 20

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start
fun getSampleSession(): Session {
    val session: Session
    val items = ArrayList<Item>()
    val people = ArrayList<Person>()
    for (i in 0..MAX) {
        val item = Item(i.toLong(), "Item" + i, people = ArrayList(), price = 5f)
        val person = Person(i.toLong(), "Person" + i, ArrayList())
        item.addPerson(person)
        items.add(item)
        person.addItem(item)
        people.add(person)
    }

    for (i in 0 until items.size) {
        if ((0..10).random() > 3) {
            val rand1 = (0..MAX).random()
            val rand2 = (0..MAX).random()
            people[rand1].addItem(items[rand2])
            items[rand2].addPerson(people[rand1])
        }
    }

    session = Session(0L, "Name", people = people, items = items)
    return session
}

//@Entity(tableName = "session")
@Entity

data class Session(@PrimaryKey(autoGenerate = true) var id: Long = 0,
                   var name: String = "",
//                   var session_id: Long = 0,
//                   @ColumnInfo(name = "session_people") val people: ArrayList<Person>,
                   @Ignore val people: ArrayList<Person> = ArrayList(),
//                   @ColumnInfo(name = "session_items") val items: ArrayList<Item>) : Serializable {
                   @Ignore val items: ArrayList<Item> = ArrayList()) : Serializable {

    fun add(item: Item, person: Person) {
        item.addPerson(person)
        person.addItem(item)
    }

//    fun finalCountdown(){ //ta da da, it's a final countdown
//        for (item in items){
//            val perPerson = item.price / item.people.size
//            for (person in item.people){
//                person.owe = person.owe + perPerson
//            }
//        }
//    }

    fun connect(item: Item, person: Person) {
        item.addPerson(person)
        person.addItem(item)
    }

    fun disconnect(item: Item, person: Person) {
        item.removePerson(person)
        person.removeItem(item)
    }

    override fun hashCode(): Int = 31 * id.hashCode() * name.hashCode() * people.hashCode() * items.hashCode()
}