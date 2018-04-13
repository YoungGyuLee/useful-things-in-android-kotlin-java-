package com.yg.edituplayout

import android.app.Activity
import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver


/**
 * Created by 2yg on 2018. 1. 9..
 */
class SoftKeyPadDetector : ViewTreeObserver.OnGlobalLayoutListener {

    // KeyPad's minimum height. not guarantee under xhdpi. you can change this value.
    private val SOFT_INPUT_MIN_HEIGHT = 200

    // root view
    private var mView: View? = null

    // View's Rect
    private val mVisibleRect = Rect()
    // View's right position
    private var mRectRight = 0
    // View's visible height
    private var mVisibleHeight = 0

    // Is show SoftKeyPad
    private var mIsVisibleSoftKeyPad = false

    // SoftKeyPad's height
    private var mSoftKeyPadHeight = 0
    // Android StatusBar's height
    private var mStatusBarHeight = 0

    // detect pause
    private var mDetectPaused = false

    private var mOnSoftKeyPadListener: OnSoftKeyPadListener? = null

    /**
     * Creator
     *
     * attention : Use after View inflated
     *
     * @param view View.
     */
    fun SoftKeyPadDetector(view: View){
        this.mView = view
        if (view is OnSoftKeyPadListener) {
            setOnSoftInputListener(view as OnSoftKeyPadListener)
        }
    }

    /**
     * Creator
     *
     * attention : Use after Activity-onCreate()'s setContentView()
     *
     * @param activity Activity
     */
    constructor(activity: Activity){
        Log.v("aaaaa","aaaaa")
        ((activity.findViewById(R.id.child_frame) as ViewGroup).getChildAt(0))
        if (activity is OnSoftKeyPadListener) {
            setOnSoftInputListener(activity as OnSoftKeyPadListener)
        }
    }

    fun SoftKeyPadDetector(activity: Activity){
        ((activity.findViewById(R.id.child_frame) as ViewGroup).getChildAt(0))
        if (activity is OnSoftKeyPadListener) {
            setOnSoftInputListener(activity as OnSoftKeyPadListener)
        }
    }


    /**
     * Creator
     *
     * attention : Use after Fragment-onCreateView()
     *
     * @param fragment Fragment
     */
    fun SoftKeyPadDetector(fragment: android.support.v4.app.Fragment) {
        //this(fragment.activity)
        if (fragment is OnSoftKeyPadListener) {
            setOnSoftInputListener(fragment as OnSoftKeyPadListener)
        }
    }

    /**
     * Set Listener
     *
     * @param onSoftKeyPadListener OnSoftKeyPadListener
     * @return SoftKeyPadDetector
     */
    fun setOnSoftInputListener(onSoftKeyPadListener: OnSoftKeyPadListener): SoftKeyPadDetector {
        this.mOnSoftKeyPadListener = onSoftKeyPadListener
        return this
    }

    fun isSoftKeyPadVisible(): Boolean {
        return this.mIsVisibleSoftKeyPad
    }

    fun getSoftKeyPadHeight(): Int {
        return this.mSoftKeyPadHeight
    }

    fun getStatusBarHeight(): Int {
        return this.mStatusBarHeight
    }

    fun getView(): View {
        return this.mView!!
    }

    fun getVisibleRect(): Rect {
        return this.mVisibleRect
    }

    fun getVisibleHeight(): Int {
        return this.mVisibleHeight
    }

    /**
     * Start Detect SoftKeyPad
     */
    fun startDetect() {
        addOnGlobalLayoutListener(this.mView!!, this)
        resumeDetect()
    }

    /**
     * Resume Detect SoftKeyPad
     */
    fun resumeDetect() {
        this.mDetectPaused = false
    }

    /**
     * Pause Detect SoftKeyPad
     */
    fun pauseDetect() {
        this.mDetectPaused = true
    }

    /**
     * Stop Detect SoftKeyPad
     */
    fun stopDetect() {
        pauseDetect()
        removeOnGlobalLayoutListener(this.mView!!, this)
    }

    /**
     * Add view to ViewTreeObserver.OnGlobalLayoutListener
     *
     * @param view View
     * @param onGlobalLayoutListener ViewTreeObserver.OnGlobalLayoutListener
     */
    fun addOnGlobalLayoutListener(view: View, onGlobalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener) {
        val viewTreeObserver = view.getViewTreeObserver()
        if (viewTreeObserver != null) {
            viewTreeObserver!!.addOnGlobalLayoutListener(onGlobalLayoutListener)
        }
    }

    /**
     * Remove view from ViewTreeObserver.OnGlobalLayoutListener
     * @param view View
     * @param onGlobalLayoutListener ViewTreeObserver.OnGlobalLayoutListener
     */
    fun removeOnGlobalLayoutListener(view: View, onGlobalLayoutListener: ViewTreeObserver.OnGlobalLayoutListener) {
        val viewTreeObserver = view.getViewTreeObserver()
        if (viewTreeObserver != null) {
            viewTreeObserver!!.removeOnGlobalLayoutListener(onGlobalLayoutListener)
        }
    }

    override fun onGlobalLayout() {
        this.mView!!.getWindowVisibleDisplayFrame(mVisibleRect)

        var isChangeOrientation = false

        if (this.mRectRight == 0) {
            this.mRectRight = this.mVisibleRect.right
        } else {
            if (this.mRectRight != this.mVisibleRect.right) {
                // Orientation's change!
                isChangeOrientation = true
                this.mRectRight = this.mVisibleRect.right
            } else {
                isChangeOrientation = false
            }
        }

        val visibleHeight = this.mVisibleRect.height()

        if (!isChangeOrientation && this.mVisibleHeight != visibleHeight) {
            this.mVisibleHeight = visibleHeight
            this.mStatusBarHeight = mVisibleRect.top

            val softInputHeight = mView!!.getRootView().getHeight() - visibleHeight - this.mStatusBarHeight
            val softInputVisible = softInputHeight > SOFT_INPUT_MIN_HEIGHT

            if (this.mIsVisibleSoftKeyPad != softInputVisible || this.mSoftKeyPadHeight != softInputHeight) {
                this.mIsVisibleSoftKeyPad = softInputVisible
                this.mSoftKeyPadHeight = softInputHeight
                if (this.mOnSoftKeyPadListener != null && !this.mDetectPaused) {
                    this.mOnSoftKeyPadListener!!.onSoftKeyPadChanged(softInputVisible, softInputHeight)
                }
            }
        }
    }
}