package com.bablo.goni.gonibablo.model

import java.io.Serializable
import java.util.*

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */
val MAX = 20
fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start
fun getSampleSession ():Session{
    val session : Session
    val items = ArrayList<Item>()
    val people = ArrayList<Person>()
    for (i in 0..MAX) {
        val item = Item("Item" + i, "Item" + i, ArrayList(), 5f)
        val person = Person("Person" + i, "Person" + i, ArrayList())
        item.addPerson(person)
        items.add(item)
        person.addItem(item)
        people.add(person)
    }

    for (i in 0 until items.size){
        if ((0..10).random() > 3){
            val rand1 = (0..MAX).random()
            val rand2 = (0..MAX).random()
            people[rand1].addItem(items[rand2])
            items[rand2].addPerson(people[rand1])
        }
    }

    session = Session("ID", "Name", people, items)
    return session
}
data class Session(val id: String, var name: String, val people: List<Person>, val items: List<Item>) : Serializable{
    fun add (item: Item, person: Person){
        item.addPerson(person)
        person.addItem(item)
    }

    fun finalCountdown(){ //ta da da, it's a final countdown
        for (item in items){
            val perPerson = item.price / item.people.size
            for (person in item.people){
                person.owe = person.owe + perPerson
            }
        }
    }
}