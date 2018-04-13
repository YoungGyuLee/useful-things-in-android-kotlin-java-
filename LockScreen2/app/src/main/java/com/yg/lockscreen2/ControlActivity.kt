package com.yg.lockscreen2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_control.*

class ControlActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)
        Common.context2 = this

        control_start_btn.setOnClickListener {
            val intent = Intent(this, MyService2::class.java)
            startService(intent)
        }
        control_stop_btn.setOnClickListener {
            val intent = Intent(this, MyService2::class.java)
            stopService(intent)
        }
    }
}
