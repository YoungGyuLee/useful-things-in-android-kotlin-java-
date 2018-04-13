package com.yg.imagezoom

import android.support.v4.view.PagerAdapter
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


/**
 * Created by 2yg on 2018. 1. 1..
 */
class CardPagerAdpater : PagerAdapter(), CardAdapter {

    private var cardView : ArrayList<CardView?>? = null
    private var cardData : ArrayList<CardItem>? = null
    private var baseElevation : Double = 0.0

    init {
        this.cardView = ArrayList()
        this.cardData = ArrayList()
    }

    override fun isViewFromObject(view: View?, object2: Any?): Boolean {
        return view === object2
    }

    override fun getCount() : Int = cardData!!.size

    override fun getBaseElevation(): Double = baseElevation

    override fun getCardViewAt(position: Int): CardView {
        return cardView!![position]!!
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        val view = LayoutInflater.from(container!!.context)
                .inflate(R.layout.adpater, container, false)
        container.addView(view)
        bind(cardData!!.get(position), view)
        val cardView2 = view.findViewById(R.id.card_view) as CardView



        if (baseElevation == 0.0) {
            baseElevation = cardView2.cardElevation.toDouble()
        }

        cardView2.maxCardElevation = (baseElevation * Common.MAX_ELEVATION_FACTOR).toFloat()
        cardView!!.set(position, cardView2)
        return view
    }

    override fun destroyItem(container: ViewGroup?, position: Int, object2: Any?) {
        super.destroyItem(container, position, object2)
        container!!.removeView(object2 as View)
        cardView!!.set(position, null)
    }

    fun addCardItem(item: CardItem) {
        cardView!!.add(null)
        cardData!!.add(item)
    }

    private fun bind(item: CardItem, view: View) {
        val imageView = view.findViewById(R.id.image_item) as ImageView
        imageView.setImageResource(item.image)
//
//        val titleTextView = view.findViewById(R.id.titleTextView) as TextView
//        val contentTextView = view.findViewById(R.id.contentTextView) as TextView
//        titleTextView.setText(item.getTitle())
//        contentTextView.setText(item.getText())
    }


}