package com.bablo.goni.gonibablo.ui.adapter

import com.bablo.goni.gonibablo.model.Item

/**
 * Created by Serhii_Bondarenko3 on 14-Nov-17.
 */
interface IItemCallback {
    fun addItem()
    fun selectItem(item: Item)
}