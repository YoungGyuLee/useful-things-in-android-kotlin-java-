package com.yg.lockscreen

import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder



class MyService : Service() {

    private var myReceiver : MyReceiver? = null

    override fun onBind(intent: Intent): IBinder? {
        //throw UnsupportedOperationException("Not yet implemented")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        myReceiver = MyReceiver()

        val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)

        registerReceiver(myReceiver, filter)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //return super.onStartCommand(intent, flags, startId)
        if (intent != null) {
            if (intent.action == null) {
                if (myReceiver == null) {
                    myReceiver = MyReceiver()
                    val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
                    registerReceiver(myReceiver, filter)
                }
            }
        }
        return Service.START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        if (myReceiver != null) {
            unregisterReceiver(myReceiver)
        }
    }
}
