package com.yg.layouttoimage

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view.isDrawingCacheEnabled = true
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.buildDrawingCache(true)

        button.setOnClickListener {
            val b = Bitmap.createBitmap(view.getDrawingCache())
            view.setDrawingCacheEnabled(false)
            val bytes = ByteArrayOutputStream()
            b.compress(Bitmap.CompressFormat.JPEG, 100, bytes)

            val f = File(Environment.getExternalStorageDirectory().toString() + File.separator + "ygyg.jpg")
            try {
                f.createNewFile()
                val fo = FileOutputStream(f)
                fo.write(bytes.toByteArray())
                fo.close()
            } catch (e: Exception) {
            }

            //finish()
        }
    }
}
