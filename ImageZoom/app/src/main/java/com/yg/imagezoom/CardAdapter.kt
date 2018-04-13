package com.yg.imagezoom

import android.support.v7.widget.CardView



/**
 * Created by 2yg on 2018. 1. 1..
 */
open interface CardAdapter {
    open fun getBaseElevation(): Double
    open fun getCardViewAt(position: Int): CardView?
    open fun getCount(): Int

}