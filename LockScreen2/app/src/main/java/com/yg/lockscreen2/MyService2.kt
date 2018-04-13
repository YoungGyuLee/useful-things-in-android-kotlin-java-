package com.yg.lockscreen2

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import butterknife.ButterKnife


class MyService2 : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return null
    }


    lateinit var params : WindowManager.LayoutParams
    lateinit var windowManager : WindowManager
    lateinit var rootView : View



    override fun onCreate() {
        super.onCreate()
        Log.v("서비스2"," 서비스2")

        windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val width = (display.width * 0.9).toInt() //Display 사이즈의 90%

        params = WindowManager.LayoutParams(width,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                        WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                PixelFormat.TRANSLUCENT)

        var layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        rootView = layoutInflater.inflate(R.layout.pokemon_bar, null)
        ButterKnife.inject(Common.context2, rootView)

//        super.onCreate()
//
//        windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
//
//        val display = windowManager.getDefaultDisplay()
//
//        val width = (display.getWidth() * 0.9).toInt() //Display 사이즈의 90%
//
//
//        params = WindowManager.LayoutParams(
//                width,
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
//                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
//                PixelFormat.TRANSLUCENT)
//
//
//        val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        rootView = layoutInflater.inflate(R.layout.call_popup_top, null)





    }

//    private void setDraggable() {
//        rootView.setOnTouchListener(new View.OnTouchListener()
//        { private int initialX; private int initialY; private float initialTouchX; private float initialTouchY; @Override public boolean onTouch(View v, MotionEvent event) { switch (event.getAction()) { case MotionEvent.ACTION_DOWN: initialX = params.x; initialY = params.y; initialTouchX = event.getRawX(); initialTouchY = event.getRawY(); return true; case MotionEvent.ACTION_UP: return true; case MotionEvent.ACTION_MOVE: params.x = initialX + (int) (event.getRawX() - initialTouchX); params.y = initialY + (int) (event.getRawY() - initialTouchY); if (rootView != null) windowManager.updateViewLayout(rootView, params); return true; } return false; } }); }
//
//    출처: http://gun0912.tistory.com/46 [박상권의 삽질블로그]


}
