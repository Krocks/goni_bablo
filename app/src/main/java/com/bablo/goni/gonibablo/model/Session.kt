package com.bablo.goni.gonibablo.model

/**
 * Created by Serhii_Bondarenko3 on 13-Nov-17.
 */
data class Session(var id : String, val name : String, val people : List<Person>, val items : List<Item>)