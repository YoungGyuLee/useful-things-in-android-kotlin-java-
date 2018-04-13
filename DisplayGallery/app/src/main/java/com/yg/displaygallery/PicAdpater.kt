package com.yg.displaygallery

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView


/**
 * Created by 2yg on 2018. 1. 5..
 */
class PicAdpater : BaseAdapter {

    var defaultItemBackground: Int = 0

    //gallery context
    private var galleryContext: Context? = null

    //array to store bitmaps to display
    private var imageBitmaps: Array<Bitmap?>? = null

    //placeholder bitmap for empty spaces in gallery
    var placeholder: Bitmap? = null

    constructor(context: Context) : super(){
        this.galleryContext = context
        //create bitmap array
        imageBitmaps  = arrayOfNulls<Bitmap>(8)
        //decode the placeholder image
        placeholder = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.unicon5)
        for (i in 0..(imageBitmaps!!.size - 1))
            imageBitmaps!![i] = placeholder
        val styleAttrs = galleryContext!!.obtainStyledAttributes(R.styleable.PicGallery)
        defaultItemBackground = styleAttrs.getResourceId(
                R.styleable.PicGallery_android_galleryItemBackground, 0)
        styleAttrs.recycle()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //create the view
        val imageView = ImageView(galleryContext)
        //specify the bitmap at this position in the array
        imageView.setImageBitmap(imageBitmaps!![position])
        //set layout options
        imageView.layoutParams = Gallery.LayoutParams(300, 200)
        //scale type within view area
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        //set default gallery item background
        imageView.setBackgroundResource(defaultItemBackground)
        //return the view
        return imageView
    }

    override fun getItem(position: Int): Any = position

    override fun getItemId(position: Int): Long  = position.toLong()

    override fun getCount(): Int = imageBitmaps!!.size

}