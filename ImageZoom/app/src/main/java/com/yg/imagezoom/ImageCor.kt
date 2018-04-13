package com.yg.imagezoom

import android.content.Context
import android.util.Log
import android.view.MotionEvent
import android.view.View

/**
 * Created by 2yg on 2018. 1. 1..
 */

class ImageCor(context: Context)// TODO Auto-generated constructor stub
    : View(context) {

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // TODO Auto-generated method stub
        super.onTouchEvent(event)
        Log.v("cor", "Aaaaa")

        //event
        //event 종류/각각의 특성

        if (event.action == MotionEvent.ACTION_DOWN) {

            val x = event.x
            val y = event.y

            val msg = "터치를 입력받음 : $x / $y"

            Log.v("cor", msg)

            return true
        }

        return false
    }
}
