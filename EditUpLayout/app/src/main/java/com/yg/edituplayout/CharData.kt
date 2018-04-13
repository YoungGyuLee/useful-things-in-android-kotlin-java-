package com.yg.edituplayout

import android.content.Context
import android.view.View
import com.github.mikephil.charting.data.ChartData



/**
 * Created by 2yg on 2018. 1. 8..
 */

object CharData {
    val TYPE_BARCHART = 0
    val TYPE_LINECHART = 1
    val TYPE_PIECHART = 2

    var mChartData: ChartData<*>? = null
    fun ChartItem(cd: ChartData<*>) {
        this.mChartData = cd
    }
    fun getItemType(): Int = 0
    fun getView(position: Int, convertView: View, c: Context): View? =  null
}