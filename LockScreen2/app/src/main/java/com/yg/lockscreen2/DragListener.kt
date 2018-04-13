package com.yg.lockscreen2

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.DragEvent
import android.view.View

/**
 * Created by 2yg on 2018. 1. 3..
 */
class DragListener : View.OnDragListener {

    val questionNormal : Drawable = Resources.getSystem().getDrawable(R.drawable.question_block_normal)
    val questionSelect : Drawable = Resources.getSystem().getDrawable(R.drawable.question_block_select)
    val unlockNormal : Drawable = Resources.getSystem().getDrawable(R.drawable.unlock_block_normal)
    val unlockSelect : Drawable = Resources.getSystem().getDrawable(R.drawable.unlock_block_select)


    override fun onDrag(v: View?, event: DragEvent?): Boolean {
        when(event!!.action){
            DragEvent.ACTION_DRAG_STARTED->{
                Log.v("DragClickListener", "ACTION_DRAG_STARTED")
            }
            DragEvent.ACTION_DRAG_ENTERED->{
                //if(v == findView)

            }
            DragEvent.ACTION_DRAG_EXITED->{

            }
        }
        return true
    }
}