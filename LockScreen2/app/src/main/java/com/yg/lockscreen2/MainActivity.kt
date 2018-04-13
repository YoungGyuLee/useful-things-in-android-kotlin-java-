package com.yg.lockscreen2

import android.content.ClipData
import android.content.ClipDescription
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_main.*
import me.imid.swipebacklayout.lib.SwipeBackLayout
import me.imid.swipebacklayout.lib.app.SwipeBackActivity


class MainActivity : SwipeBackActivity(), SwipeBackLayout.SwipeListener, View.OnTouchListener,
        View.OnDragListener, View.OnLongClickListener
{
    var prevX : Int = 0
    var prevY : Int = 0

    var btnX : Float = 0.0F
    var btnY : Float = 0.0F

    //var time : TimerT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)


        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD)


        var mySwipeBackLayout = swipeBackLayout

        mySwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT or SwipeBackLayout.EDGE_RIGHT)
        mySwipeBackLayout.addSwipeListener(this)

        main_button.setOnLongClickListener(this)
        main_button.tag = "monsterBall~~"
        main_question.setOnDragListener(this)
        main_unlock.setOnDragListener(this)

        btnX = main_button.x
        btnY = main_button.y



        //main_button.setOnTouchListener(this)


//    main_button.setOnTouchListener(object : View.OnTouchListener {
//
//        override fun onTouch(v: View, event: MotionEvent): Boolean {
//
//            val par = v.layoutParams as RelativeLayout.LayoutParams
//            when (event.action) {
//                MotionEvent.ACTION_MOVE -> {
//                    par.topMargin += event.rawY.toInt() - prevY
//                    prevY = event.rawY.toInt()
//                    par.leftMargin += event.rawX.toInt() - prevX
//                    prevX = event.rawX.toInt()
//                    v.layoutParams = par
//                    return true
//                }
//                MotionEvent.ACTION_UP -> {
//                    par.topMargin += event.rawY.toInt() - prevY
//                    par.leftMargin += event.rawX.toInt() - prevX
//                    v.layoutParams = par
//                    return true
//                }
//                MotionEvent.ACTION_DOWN -> {
//                    prevX = event.rawX.toInt()
//                    prevY = event.rawY.toInt()
//                    par.bottomMargin = -2 * v.height
//                    par.rightMargin = -2 * v.width
//                    v.layoutParams = par
//                    return true
//                }
//            }
//            return false
//        }
//    })




//        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
//                or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD)
//
//        keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
//        if (keyguardManager!!.inKeyguardRestrictedInputMode()) {
//            setTheme(android.R.style.Theme_NoTitleBar)
//            window.setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
//            window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD)
//            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
//            keyguardLock = keyguardManager!!.newKeyguardLock(Context.KEYGUARD_SERVICE)
//        } else {
//            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
//            window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL)
////            requestWindowFeature(Window.FEATURE_NO_TITLE)
//            wakeLock = (getSystemService(Context.POWER_SERVICE) as PowerManager).newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP, "TAG")
//        }
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {

        val par = v.layoutParams as RelativeLayout.LayoutParams
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                par.topMargin += event.rawY.toInt() - prevY
                prevY = event.rawY.toInt()
                par.leftMargin += event.rawX.toInt() - prevX
                prevX = event.rawX.toInt()
                v.layoutParams = par
                return true
            }
            MotionEvent.ACTION_UP -> {
                par.topMargin += event.rawY.toInt() - prevY
                par.leftMargin += event.rawX.toInt() - prevX
                v.layoutParams = par
                return true
            }
            MotionEvent.ACTION_DOWN -> {
                prevX = event.rawX.toInt()
                prevY = event.rawY.toInt()
                par.bottomMargin = -2 * v.height
                par.rightMargin = -2 * v.width
                v.layoutParams = par
                return true
            }
        }
        return false
    }

    override fun onScrollStateChange(state: Int, scrollPercent: Float) {
        finish()
    }

    override fun onEdgeTouch(edgeFlag: Int) {
        finish()
    }

    override fun onScrollOverThreshold() {
        finish()
    }



    override fun onDrag(v: View?, event: DragEvent?): Boolean {
        when(event!!.action){
            DragEvent.ACTION_DRAG_STARTED->{
                Log.v("DragClickListener", "ACTION_DRAG_STARTED")
            }
            DragEvent.ACTION_DRAG_ENTERED->{
                if(v == main_question){
                    Log.v("DragClickListener", "in1")
                    main_question.setImageResource(R.drawable.question_block_select)
                    main_unlock.setImageResource(R.drawable.unlock_block_normal)
                    //v!!.setBackgroundResource(R.drawable.question_block_select)
                    //v!!.background = questionSelect
                }else if(v == main_unlock){
                    Log.v("DragClickListener", "in2")
                    main_question.setImageResource(R.drawable.question_block_normal)
                    main_unlock.setImageResource(R.drawable.unlock_block_select)
                    //v!!.setBackgroundResource(R.drawable.unlock_block_select)
                    //v!!.background = unlockSelect
                }
            }
            DragEvent.ACTION_DRAG_EXITED->{
                    main_question.setImageResource(R.drawable.question_block_normal)
                    main_unlock.setImageResource(R.drawable.unlock_block_normal)
                    Log.v("DragClickListener", "out1")
            }
            DragEvent.ACTION_DROP->{
                val view = event.localState as View
                view.visibility = View.VISIBLE
                view.x = btnX
                view.y = btnY
                return false
            }
            else->{
                return false
            }
        }
        return true
    }


    override fun onLongClick(v: View?): Boolean {
        val item = ClipData.Item(
                "Aaaa" as CharSequence)

        val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
        val data = ClipData("Aaaa",
                mimeTypes, item)
        val shadowBuilder = View.DragShadowBuilder(
                v)

        v!!.startDrag(data, // data to be dragged
                shadowBuilder, // drag shadow
                v, // 드래그 드랍할  Vew
                0 // 필요없은 플래그
        )

        v.visibility = View.INVISIBLE
        return true
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onResume() {
        super.onResume()

    }

}
