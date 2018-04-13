package com.yg.edituplayout

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*








/***
 *
 * */

class MainActivity : AppCompatActivity(){


    private var mSoftKeyPadDetector: SoftKeyPadDetector? = null

    val windowVisibleDisplayFrame = Rect()
    var lastVisibleDecorViewHeight : Int = 0
    var root : View? = null
    var length : Int = 0
    val MIN_KEYBOARD_HEIGHT_PX = 150
    var decorView : View? = null
    private var mSoftKeyPadDetector2: SoftKeyPadDetector2? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        decorView = this.window.decorView

        mSoftKeyPadDetector2 = SoftKeyPadDetector2(this)
        mSoftKeyPadDetector2!!.setOnSoftInputListener(mSoftKeyPadChangeListener2)


        //window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        //toolbar.bringToFront()
        //val window2 : Window = window.container!!.
        //window2.layoutInflater.inflate(R.id.child_frame, )
        //window2.setContentView(R.id.child_frame)

//        val rl = findViewById(R.id.container) as RelativeLayout
//        val iv = RelativeLayout(this)
//        val params = RelativeLayout.LayoutParams(30, 40)
//

//        params.leftMargin = 50
//        params.topMargin = 60
//        iv.bringToFront()
//        rl.addView(iv, params)
//        val keboardView = KeyboardView(applicationContext, null)
//

//        Log.v("size", keboardView.height.toString())

       // decorView!!.viewTreeObserver.addOnGlobalLayoutListener(this)


        edit.setOnClickListener {
            //Log.v("length", getSoftMenuHeight().toString())
            //Log.v("length2", getSoftMenuHeight2().toString())
            //layer_layout.scrollY = 961
            Log.v("aAA", edit.height.toString())
            //child_frame.scrollY = height2
        }

        //root = window.decorView


//        root
//        .getViewTreeObserver().addOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener {
//            val heightDiff = root.getRootView().getHeight() - root.getHeight()
//            // IF height diff is more then 150, consider keyboard as visible.
//        })



    }

    override fun onResume() {
        super.onResume()
        mSoftKeyPadDetector2!!.startDetect()
    }

    override fun onPause() {
        mSoftKeyPadDetector2!!.stopDetect()
        super.onPause()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // receive Orientation changed.
    }

    override fun onBackPressed() {
        layer_layout.scrollY = 0
        super.onBackPressed()
    }

    fun getSoftMenuHeight() : Int{
        val resources = this.resources
        var resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        var deviceHeight = 0
        if(resourceId > 0){
            deviceHeight = resources.getDimensionPixelSize(resourceId)
        }
        return deviceHeight
    }

    //checkKeyBoardHeight()

//    private void checkKeyboardHeight(final View parentLayout)
//    {
//        chatRootLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
//        {
//            @Override
//            public void onGlobalLayout()
//            {
//                Rect r = new Rect();
//
//                chatRootLayout.getWindowVisibleDisplayFrame(r);
//
//                int screenHeight = chatRootLayout.getRootView().getHeight();
//                int keyboardHeight = screenHeight - (r.bottom);
//
//                if (previousHeightDiffrence - keyboardHeight > 50)
//                {
//                    // Do some stuff here
//                }
//
//                previousHeightDiffrence = keyboardHeight;
//                if (keyboardHeight> 100)
//                {
//                    isKeyBoardVisible = true;
//                    changeKeyboardHeight(keyboardHeight);
//                }
//                else
//                {
//                    isKeyBoardVisible = false;
//                }
//            }
//        })

    fun hasSoftMennu() : Boolean {
        var hasMenuKey  : Boolean = ViewConfiguration.get(applicationContext).hasPermanentMenuKey()
        var hasBackKey : Boolean = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK)
        if(!hasMenuKey && !hasBackKey){
            return true
        }else{
            return false
        }
    }


    fun getSoftMenuHeight2() : Int{
        var resourcess : Resources = this.resources
        var resourceId : Int = resourcess.getIdentifier("navigation_bar_height", "dimen", "android")
        var deviceHeight = 0

        if(resourceId > 0){
            deviceHeight = resourcess.getDimensionPixelOffset(resourceId)
        }
        return deviceHeight
    }

    var height2 : Int = 0

    private val mSoftKeyPadChangeListener2 = object : OnSoftKeyPadListener2 {
        override fun onSoftKeyPadChanged(visible: Boolean, height: Int) {
            if (visible) {
                Log.v("visible", "visible")
                height2 = convertPixelsToDp(height, this@MainActivity)
                Toast.makeText(this@MainActivity, "SoftKeyPad show.\nheight:$height", Toast.LENGTH_SHORT).show()
            } else {
                Log.v("visible", "inVisible")
                Toast.makeText(this@MainActivity, "SoftKeyPad hide.", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    private val mSoftKeyPadChangeListener2 = OnSoftKeyPadListener2 { visible, height ->
//        if (visible) {
//            Toast.makeText(this@Main2Activity, "SoftKeyPad show.\nheight:$height", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this@Main2Activity, "SoftKeyPad hide.", Toast.LENGTH_SHORT).show()
//        }
//    }v

    fun convertPixelsToDp(px : Int, context : Context) : Int{
        var resources = context.resources
        var metrics = resources.displayMetrics
        var dp = px/(metrics.densityDpi/160)
        return dp
    }

}
