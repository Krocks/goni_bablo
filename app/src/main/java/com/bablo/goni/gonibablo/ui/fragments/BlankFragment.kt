package com.bablo.goni.gonibablo.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.bablo.goni.gonibablo.R
import com.bablo.goni.gonibablo.model.Item
import com.bablo.goni.gonibablo.model.Person
import com.bablo.goni.gonibablo.model.Session
import com.bablo.goni.gonibablo.model.getSampleSession
import com.bablo.goni.gonibablo.ui.adapter.IItemCallback
import com.bablo.goni.gonibablo.ui.adapter.IPersonCallback
import com.bablo.goni.gonibablo.ui.adapter.ItemRecyclerAdapter
import com.bablo.goni.gonibablo.ui.adapter.PersonRecyclerAdapter
import com.bablo.goni.gonibablo.ui.dialog.DialogUtil
import kotlinx.android.synthetic.main.fragment_list.*
import java.util.ArrayList


/**
 * A simple [Fragment] subclass.
 */
class BlankFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_list, container, false)
        init(view)
        return view
    }

//    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        init()
//    }

    private fun init(view: View) {
        val session = getSession()
        initItems(session.items, view)
        initPeople(session.people, view)
    }

    private fun getSession(): Session {
//        return arguments.getSerializable(SESSION) as Session
        return getSampleSession()
    }

    private fun initItems(items : List<Item>, view: View) {
        val itemsRecycle = view.findViewById<RecyclerView>(R.id.items)
        val adapter = ItemRecyclerAdapter(items, object : IItemCallback {
            override fun addItem() {
//                Toast.makeText(context, "ADD ITEM", Toast.LENGTH_LONG).show()
//                DialogUtil.getItemAddDialog(context, { name, price -> Toast.makeText(context, "Price $name ,name $name", Toast.LENGTH_SHORT).show() })
                DialogUtil.getItemAddDialog(context, object : DialogUtil.OnDialogItemAdd{
                    override fun onItemAdd(name: String, price: Float?) {
                        Toast.makeText(context, "Price $name ,name $name", Toast.LENGTH_SHORT).show()
                    }
                })
            }

            override fun selectItem(item: Item) {
               initPeople(item.people, view)
            }
        })
        itemsRecycle.layoutManager = LinearLayoutManager(context)
        itemsRecycle.adapter = adapter
    }

    private fun initPeople(people : List<Person>, view: View) {
        val peopleRecycler = view.findViewById<RecyclerView>(R.id.people)
        val adapter = PersonRecyclerAdapter(people, object : IPersonCallback {
            override fun addPerson() {
                Toast.makeText(context, "ADD Person", Toast.LENGTH_LONG).show()
            }

            override fun selectPerson(person: Person) {
                initItems(person.items, view)
            }
        })
        peopleRecycler.layoutManager = LinearLayoutManager(context)
        peopleRecycler.adapter = adapter
    }


//    companion object {
//        private val SESSION = "session"
//
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @session session Session model.
//         * @return A new instance of fragment ListFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        fun newInstance(session: Session): BlankFragment {
//            val fragment = BlankFragment()
//            val args = Bundle()
//            args.putSerializable(SESSION, session)
//            fragment.arguments = args
//            return fragment
//        }
//    }
}// Required empty public constructor
