package com.yg.edituplayout

import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.formatter.YAxisValueFormatter

/**
 * Created by 2yg on 2018. 1. 8..
 */
class ValueFormatter : YAxisValueFormatter {
    override fun getFormattedValue(value: Float, yAxis: YAxis?): String {
        return Math.round(value).toString() + ""
    }
}