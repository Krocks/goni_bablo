package com.bablo.goni.gonibablo.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import com.bablo.goni.gonibablo.R
import com.bablo.goni.gonibablo.model.Item
import com.bablo.goni.gonibablo.model.Person
import com.bablo.goni.gonibablo.model.Session
import com.bablo.goni.gonibablo.model.getSampleSession
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 */
class AddItemFragment : Fragment() {
    val map = HashMap<Person, View>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_add_item, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun getSession(): Session = getSampleSession()

    private fun initUI() {
        val session = getSession()
        val layoutForPople = view!!.findViewById<LinearLayout>(R.id.add_item_layout)
        for (person in session.people) {
//            val personLayout = View.inflate(context, R.layout.view_add_item_person, layoutForPople)
            val personLayout = layoutInflater.inflate(R.layout.view_add_item_person, layoutForPople, false)
            val tvName = personLayout!!.findViewById<TextView>(R.id.add_item_person_name)
            tvName.text = person.name
            map.put(person, personLayout)
            layoutForPople.addView(personLayout)
        }
        val btnAdd = view!!.findViewById<Button>(R.id.add_item_add)
        btnAdd.setOnClickListener({ addItem(session) })
    }

    private fun addItem(session: Session) {
        if (!checkSum(session)) return

        val name = view!!.findViewById<TextView>(R.id.add_item_name).text.toString()
        val price = view!!.findViewById<TextView>(R.id.add_item_price).text.toString().toFloat()
        val item = Item(name = name, price = price)
        session.items.add(item)
        for (person in session.people) {
            val personsLayout = map[person]
            val checkBox = personsLayout!!.findViewById<CheckBox>(R.id.add_item_person_checkbox)
//            val personPayed = personsLayout!!.findViewById<EditText>(R.id.add_item_person_add_money).text.toString().toFloat()
            val personPayed = getFloatEditText(person)
            if (checkBox.isChecked) {
                session.connect(item, person)
            }
            person.givenMoney(personPayed)
        }
    }

    private fun checkSum(session: Session): Boolean {
        val sum = view!!.findViewById<EditText>(R.id.add_item_price).text.toString().toFloat()
        var enteredSum = 0f
        for (person in session.people) {
            var personSum = getFloatEditText(person)
//            if (map[person]!!.findViewById<EditText>(R.id.add_item_person_add_money).text.toString().isNotEmpty()) {
//                personSum = map[person]!!.findViewById<EditText>(R.id.add_item_person_add_money).text.toString().toFloat()
//            }

            enteredSum += personSum
        }
        if (sum != enteredSum) {
            wrongSum()
            return false
        }
        return true
    }

    private fun wrongSum() {
        Toast.makeText(context, R.string.wrong_sum, Toast.LENGTH_SHORT).show()
    }

    private fun getFloatEditText(person: Person): Float {
        if (map[person] == null) {
            Timber.e("map by person null") //WTF ????
        }
        if (map[person]!!.findViewById<EditText>(R.id.add_item_person_add_money) == null) Timber.e("find by id null")
        if (map[person]!!.findViewById<EditText>(R.id.add_item_person_add_money).text == null) {
            Timber.e("text null")
        }

        if (map[person]!!.findViewById<EditText>(R.id.add_item_person_add_money).text.toString().isNotEmpty()) {
            return map[person]!!.findViewById<EditText>(R.id.add_item_person_add_money).text.toString().toFloat()
        }
        return 0f
    }

}
