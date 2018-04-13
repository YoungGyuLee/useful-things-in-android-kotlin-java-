package com.yg.lockscreen2

import android.content.ClipData
import android.content.ClipDescription
import android.view.View



/**
 * Created by 2yg on 2018. 1. 3..
 */
class LongClickListener : View.OnLongClickListener {
    override fun onLongClick(view: View?): Boolean {
        val item = ClipData.Item(
                view!!.tag as CharSequence)

        val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
        val data = ClipData(view!!.tag.toString(),
                mimeTypes, item)
        val shadowBuilder = View.DragShadowBuilder(
                view)

        view!!.startDrag(data, // data to be dragged
                shadowBuilder, // drag shadow
                view, // 드래그 드랍할  Vew
                0 // 필요없은 플래그
        )

        view!!.visibility = View.INVISIBLE
        return true
    }
}