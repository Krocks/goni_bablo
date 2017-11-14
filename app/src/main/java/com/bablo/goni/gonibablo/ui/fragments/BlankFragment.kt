package com.bablo.goni.gonibablo.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bablo.goni.gonibablo.R
import com.bablo.goni.gonibablo.model.Item
import com.bablo.goni.gonibablo.model.Person
import com.bablo.goni.gonibablo.model.Session
import com.bablo.goni.gonibablo.ui.adapter.ItemRecyclerAdapter
import com.bablo.goni.gonibablo.ui.adapter.PersonRecyclerAdapter
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
        initItems(session, view)
        initPeople(session, view)
    }

    private fun getSession(): Session {
//        return arguments.getSerializable(SESSION) as Session
        val session : Session
        val items = ArrayList<Item>()
        for (i in 0..9) {
            val item = Item("Item" + i, "Item" + i, ArrayList())
            items.add(item)
        }

        val people = (0..9).map { Person("Item" + it, "Item" + it, ArrayList()) }
        session = Session("ID", "Name", people, items)
        return session
    }

    private fun initItems(session: Session, view: View){
        val itemsRecycle = view.findViewById<RecyclerView>(R.id.items)
        val adapter  = ItemRecyclerAdapter(session.items)
        itemsRecycle.layoutManager = LinearLayoutManager(context)
        itemsRecycle?.adapter = adapter
    }

    private fun initPeople(session: Session, view: View){
        val peopleRecycler = view.findViewById<RecyclerView>(R.id.people)
        val adapter  = PersonRecyclerAdapter(session.people)
        peopleRecycler.layoutManager = LinearLayoutManager(context)
        peopleRecycler?.adapter = adapter
    }


//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     *
//     *
//     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
//     */
//    interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onFragmentInteraction(uri: Uri)
//    }

    companion object {
        private val SESSION = "session"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @session session Session model.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(session: Session): BlankFragment {
            val fragment = BlankFragment()
            val args = Bundle()
            args.putSerializable(SESSION, session)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
