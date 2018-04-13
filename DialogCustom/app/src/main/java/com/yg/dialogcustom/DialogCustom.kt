package com.yg.dialogcustom

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.custom_dialog.*



/**
 * Created by 2yg on 2018. 1. 2..
 */

class DialogCustom(myContext : Context?,
        private var content : String?, private var leftListener : View.OnClickListener?,
                   private var rightListener : View.OnClickListener?,
                   private var left : String?, private var right : String?) : Dialog(myContext, android.R.style.Theme_Translucent_NoTitleBar) {
    private var rightText: String = ""
    private var leftText: String = ""
    init {
        this.leftText = left!!
        this.rightText = right!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lpWindow = WindowManager.LayoutParams()
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND
        lpWindow.dimAmount = 0.8f
        window!!.attributes = lpWindow
        lpWindow.gravity = Gravity.BOTTOM

        setContentView(R.layout.custom_dialog)

        btn_left.text = leftText
        btn_right.text = rightText







        if (leftListener != null && rightListener != null) {
            btn_left.setOnClickListener(leftListener)
            btn_right.setOnClickListener(rightListener)
        } else if (leftListener != null && rightListener == null) {
            btn_left.setOnClickListener(rightListener)
        } else {

        }

        dlg_content.text = content
    }

}
