package com.bablo.goni.gonibablo.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.EditText

import com.bablo.goni.gonibablo.R

/**
 * Created by Serhii_Bondarenko3 on 15-Nov-17.
 */

object DialogUtil {
    fun getItemAddDialog(context: Context, OnDialogItemAdd: OnDialogItemAdd): Dialog {
        val dialog = AlertDialog.Builder(context)
        val view = View.inflate(context, R.layout.dialog_add_item, null)
        dialog.setView(view)
        dialog.setNegativeButton(R.string.no) { dialog, _ -> dialog.dismiss() }
        dialog.setPositiveButton(R.string.ok) { _, _ ->
            val name = (view.findViewById<View>(R.id.dialog_item_name) as EditText).text.toString()
            val price = java.lang.Float.valueOf((view.findViewById<View>(R.id.dialog_item_cost) as EditText).text.toString())
            OnDialogItemAdd.onItemAdd(name, price)
        }
        return dialog.show()
    }

    interface OnDialogItemAdd {
        fun onItemAdd(name: String, price: Float?)
    }
}
