package com.yg.fragmentexample

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_child.view.*

/**
 * Created by 2yg on 2018. 1. 4..
 */
class ChildeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater!!.inflate(R.layout.fragment_child, container, false)
        v.child_button.setOnClickListener {
            AddFragment()
        }
        return v
    }

    fun AddFragment() {
        val fm = activity.fragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_container, OtherFragment(), "Other")
        transaction.addToBackStack(null)
        transaction.commit()
    }

}