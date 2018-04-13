package com.yg.lockscreen2

import android.app.KeyguardManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent



class MyReceiver : BroadcastReceiver() {

    private var km : KeyguardManager? = null
    private var keyLock : KeyguardManager.KeyguardLock? = null

    override fun onReceive(context: Context, intent: Intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        if (intent.action == (Intent.ACTION_SCREEN_OFF)) {
//            val i = Intent(context, MainActivity::class.java)
//            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            context.startActivity(i)
//        }



        if (intent.action==Intent.ACTION_SCREEN_OFF) {

            if (km == null)
                km = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager



            if (keyLock == null)
                keyLock = km!!.newKeyguardLock(Context.KEYGUARD_SERVICE)



            disableKeyguard()


            val i = Intent(context, MainActivity::class.java)

            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            context.startActivity(i)

        }

//        throw UnsupportedOperationException("Not yet implemented")

    }

    fun reenableKeyguard(){
        keyLock!!.reenableKeyguard()
    }

    fun disableKeyguard(){
        keyLock!!.disableKeyguard()
    }
}
