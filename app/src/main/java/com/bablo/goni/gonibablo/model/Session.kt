package com.bablo.goni.gonibablo.model

import java.io.Serializable

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */
data class Session(val id: String, var name: String, val people: List<Person>, val items: List<Item>) : Serializable