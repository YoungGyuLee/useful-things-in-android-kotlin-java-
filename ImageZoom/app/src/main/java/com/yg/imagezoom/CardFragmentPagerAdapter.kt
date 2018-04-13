package com.yg.imagezoom

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.widget.CardView
import android.util.Log
import android.view.ViewGroup

class CardFragmentPagerAdapter(fm: FragmentManager, private val mBaseElevation: Float) : FragmentStatePagerAdapter(fm), CardAdapter {
    private var mFragments : ArrayList<CardFragment>? = null
    init {
        this.mFragments = ArrayList()
        for (i in 0..4) {
            Log.v("7","7")
            val fragment = CardFragment()
            mFragments!!.add(fragment)

          //  addCardFragment(CardFragment())
        }
    }

    override fun getBaseElevation(): Double {
        Log.v("6","6")

        return mBaseElevation.toDouble()
    }

    override fun getCardViewAt(position: Int): CardView? {
        Log.v("5","5")

        return mFragments!![position].cardView
    }

    override fun getCount(): Int {
        Log.v("4","4")
        return mFragments!!.size
    }

    override fun getItem(position: Int): Fragment {
        Log.v("3","3")

        return mFragments!![position]
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position)
        Log.v("2","2")
        mFragments!![position] = fragment as CardFragment
        return fragment
    }

    fun addCardFragment(fragment: CardFragment) {
        Log.v("1","1")
        mFragments!!.add(fragment)
    }

}
