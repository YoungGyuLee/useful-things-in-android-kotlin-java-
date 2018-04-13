package com.yg.dialogcustom

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * Created by 2yg on 2018. 1. 3..
 */

class MainFragment : Fragment() {
    var customDialog : DialogCustom? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_main, container, false)
        Log.v("frag", "createView")
        if(arguments != null){
            //v!!.first_text.text = arguments.getString("title")
        }

        v.fragment_main.setOnClickListener {
            floatingDialog()
        }
        return v
    }

    fun floatingDialog() {
        val content = "다이얼로그입니당?"
        customDialog = DialogCustom(this.context, content, addLeftListener, addRightListener, "취소", "추가")
        customDialog!!.show()
    }

    private val addLeftListener : View.OnClickListener? = View.OnClickListener {
        frag_layout.setBackgroundColor(Color.parseColor("#121212"))
        customDialog!!.dismiss()
    }

    private val addRightListener : View.OnClickListener? = View.OnClickListener {
        customDialog!!.dismiss()
    }

    override fun onResume() {
        super.onResume()
        Log.v("frag", "resume")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("frag", "create")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.v("frag", "result")
    }

    override fun onStart() {
        super.onStart()
        Log.v("frag", "start")
    }

}
