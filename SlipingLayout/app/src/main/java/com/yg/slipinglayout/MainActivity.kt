package com.yg.slipinglayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import com.mancj.slideup.SlideUp
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), SlideUp.SlideListener {

    var slideUp : SlideUp? = null
    //var dim : View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        slideUp = SlideUp(slideView)
        slideUp!!.hideImmediately()
        main_button.setOnClickListener {
            main_button.visibility = View.GONE
            slideUp!!.animateIn()
            //main_button.hid
        }
        main_button.startAnimation(AnimationUtils.loadAnimation(this, R.anim.shake_anim))


        slideUp!!.setSlideListener(this)
        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    override fun onVisibilityChanged(i: Int) {
        if(i == View.GONE){
            main_button.visibility = View.VISIBLE
        }
    }

    override fun onSlideDown(v: Float) {
        dim.alpha = (1 - (v/300))
    }
}
