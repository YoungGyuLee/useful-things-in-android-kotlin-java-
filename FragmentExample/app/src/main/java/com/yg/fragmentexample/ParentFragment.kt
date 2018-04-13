package com.yg.fragmentexample

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by 2yg on 2018. 1. 4..
 */
class ParentFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater!!.inflate(R.layout.fragment_parent, container, false)
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AddFragment()
    }

    fun AddFragment() {
        val fm = activity.fragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.child_frame, ChildeFragment(), "child")
        transaction.addToBackStack(null)
        transaction.commit()
    }
}