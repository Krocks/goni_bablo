package com.bablo.goni.gonibablo.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bablo.goni.gonibablo.R


/**
 * A simple [Fragment] subclass.
 */
class AddItemFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_add_item, container, false)
    }

}// Required empty public constructor
