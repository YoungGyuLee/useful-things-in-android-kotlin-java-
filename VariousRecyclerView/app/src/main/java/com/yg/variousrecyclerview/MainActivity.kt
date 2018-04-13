package com.yg.variousrecyclerview

import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipe_layout.setOnRefreshListener(this)
        //갱신 리스너 등록
        swipe_layout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light)
        //갱신할 때 색상 적용
    }
    override fun onRefresh() {
        countTime()
        //갱신함수 오버라이드 이제 스와이프 했을 때 할 일은 여기에 작성
    }

    fun countTime(){
        val handler = Handler()
        handler.postDelayed({
            text.text = "change!!"
            swipe_layout.isRefreshing = false
        }, 3000)
    }
}
