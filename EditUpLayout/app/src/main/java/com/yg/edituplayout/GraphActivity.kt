package com.yg.edituplayout

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_graph.*

class GraphActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)
        initData()
    }

    fun initData(){
        var label : ArrayList<String> = ArrayList()
        label.add("yg1")
        label.add("yg2")
        label.add("yg3")
        label.add("yg4")
        label.add("yg5")
        label.add("yg6")

        var datas : ArrayList<Entry> = ArrayList()
        datas.add(Entry(10F, 1))
        datas.add(Entry(93F, 2))
        datas.add(Entry(25F, 3))
        datas.add(Entry(64F, 4))
        datas.add(Entry(87F, 5))
        datas.add(Entry(43F, 6))


        val entries1 = java.util.ArrayList<Entry>()
        entries1.add(Entry(11F, 1))
        entries1.add(Entry(43F, 2))
        entries1.add(Entry(23F, 3))
        entries1.add(Entry(65F, 4))
        entries1.add(Entry(77F, 5))
        entries1.add(Entry(10F, 6))


        var lines = ArrayList<LineDataSet>()
        var lineDataSet = LineDataSet(datas, "데이터")
        lineDataSet.setColor(Color.rgb(231, 55, 112))
        lineDataSet.setCircleColor(Color.rgb(231, 55, 112))
        lineDataSet.setCircleColorHole(Color.rgb(231, 55, 112))
        lineDataSet.setCircleSize(3f)
        lineDataSet.setLineWidth(2f)





        lines.add(lineDataSet)

        //lineChart.setData(LineData(labels, lines))

        chart.data = LineData(label, lines)
        chart.setTouchEnabled(false) // 터치 금지
        chart.setDragEnabled(false) // 드래그 금지

        val xAxis = chart.getXAxis()
        val leftAxis = chart.getAxisLeft()
        val rightAxis = chart.getAxisRight()
        val legend = chart.getLegend()

        legend.setEnabled(false)
//        legend.setTextColor(Color.WHITE);
//        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM) // x축 레이블 하단에 배치
        xAxis.setDrawGridLines(false)
        xAxis.setTextColor(Color.WHITE)
        xAxis.setAxisLineWidth(2f)
        xAxis.setAxisLineColor(Color.WHITE)
        xAxis.setTextSize(15f)

        leftAxis.setLabelCount(6, true)
        leftAxis.setAxisMaxValue(5f)
        leftAxis.setAxisMinValue(1f)

        leftAxis.setTextColor(Color.WHITE)
        leftAxis.setAxisLineWidth(2f)
        leftAxis.setAxisLineColor(Color.WHITE)
        leftAxis.setDrawGridLines(false)
        leftAxis.setTextSize(15f)

        rightAxis.setDrawLabels(false) // y우측 레이블 안보이게
        rightAxis.setDrawGridLines(false)
        rightAxis.setDrawAxisLine(false)

        chart.setDescription("") // 설명 없애기
        for (i in 0..99) {
            chart.animateX(4000, Easing.EasingOption.Linear) // 애니메이션 효과
        }

        chart.setBorderColor(Color.WHITE)
        chart.setGridBackgroundColor(Color.argb(0, 1, 42, 106))

        lineDataSet.setDrawValues(false) // 점 마다의 값 지우기
        //lines[1].setDrawValues(false)
        // 점 마다의 값 지우기
        //lines[1].setDrawValues(false)
        //leftAxis.setValueFormatter(MyValueFormatter())

        leftAxis.valueFormatter = ValueFormatter()
        ///////////////////////////////////////////////////////////////////////////////////

        chart.invalidate()// 적용 완료
        chart.notifyDataSetChanged()
    }
}
