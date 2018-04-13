package com.yg.imagezoom

import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_adpater.*

/**
 * Created by 2yg on 2018. 1. 1..
 */

class CardFragment : Fragment() {
    var cardView: CardView? = null
    init {
        cardView = card_view
    }

    @Nullable
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_adpater, container, false)
         //= view.findViewById(R.id.card_view) as CardView
        card_view!!.setMaxCardElevation(cardView!!.getCardElevation()
                        * Common.MAX_ELEVATION_FACTOR)
        Log.v("9","9")
        return view
    }

//    fun getCardView(): CardView? {
//        return cardView
//    }


}
