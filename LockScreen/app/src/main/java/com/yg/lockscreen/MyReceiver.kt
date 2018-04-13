package com.yg.lockscreen

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent



class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw UnsupportedOperationException("Not yet implemented")
        if (intent.action.equals(Intent.ACTION_SCREEN_OFF)) {
            val i = Intent(context, MainActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }

    }
}
