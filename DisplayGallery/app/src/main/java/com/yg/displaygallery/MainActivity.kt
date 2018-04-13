package com.yg.displaygallery

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream





class MainActivity : AppCompatActivity() {
    private val REQ_CODE_SELECT_IMAGE = 100
    private var data: Uri? = null


    private var picAdpater : PicAdpater? = null
    private val PICKER = 1
    //variable to store the currently selected image
    private val currentPic = 0

    var projection = arrayOf(MediaStore.Images.ImageColumns._ID,
            MediaStore.Images.ImageColumns.DATA,
            MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
            MediaStore.Images.ImageColumns.DATE_TAKEN,
            MediaStore.Images.ImageColumns.MIME_TYPE)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            changeImage()
        }

        val cursor = applicationContext.contentResolver
                .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection,
                        null, null, MediaStore.Images.ImageColumns.DATE_MODIFIED + " DESC")

        if (cursor.moveToFirst()) {
            Log.v("이미지", "이미지")
            val imageView = findViewById(R.id.i1) as ImageView
            Log.v("이미지", cursor.toString())
            val imageLocation = cursor.getString(1)
            val imageFile = File(imageLocation)
            if (imageFile.exists()) {   // TODO: is there a better way to do this?

                Glide.with(this).load(imageFile).into(imageView)
            }
        }
        if(cursor.move(0)){
            val imageView = findViewById(R.id.i1) as ImageView
            val imageLocation = cursor.getString(1)
            val imageFile = File(imageLocation)
            if (imageFile.exists()) {   // TODO: is there a better way to do this?
                //val bm = BitmapFactory.decodeFile(imageLocation)
                //imageView.setImageBitmap(bm)
                Glide.with(this).load(imageFile).into(imageView)
            }
        }
        if(cursor.move(1)){
            val imageView = findViewById(R.id.i2) as ImageView
            val imageLocation = cursor.getString(1)
            val imageFile = File(imageLocation)
            if (imageFile.exists()) {   // TODO: is there a better way to do this?
                //val bm = BitmapFactory.decodeFile(imageLocation)
                //imageView.setImageBitmap(bm)
                Glide.with(this).load(imageFile).into(imageView)
            }  }
        if(cursor.move(2)){
            val imageView = findViewById(R.id.i3) as ImageView
            val imageLocation = cursor.getString(1)
            val imageFile = File(imageLocation)
            if (imageFile.exists()) {   // TODO: is there a better way to do this?
                //val bm = BitmapFactory.decodeFile(imageLocation)
                //imageView.setImageBitmap(bm)
                Glide.with(this).load(imageFile).into(imageView)
            }  }
        if(cursor.move(3)){
            val imageView = findViewById(R.id.i4) as ImageView
            val imageLocation = cursor.getString(1)
            val imageFile = File(imageLocation)
            if (imageFile.exists()) {   // TODO: is there a better way to do this?
                //val bm = BitmapFactory.decodeFile(imageLocation)
                //imageView.setImageBitmap(bm)
                Glide.with(this).load(imageFile).into(imageView)
            } }
        if(cursor.move(4)){
            val imageView = findViewById(R.id.i5) as ImageView
            val imageLocation = cursor.getString(1)
            val imageFile = File(imageLocation)
            if (imageFile.exists()) {   // TODO: is there a better way to do this?
                //val bm = BitmapFactory.decodeFile(imageLocation)
                //imageView.setImageBitmap(bm)
                Glide.with(this).load(imageFile).into(imageView)
            }  }
        if(cursor.move(5)){
            val imageView = findViewById(R.id.i6) as ImageView
            val imageLocation = cursor.getString(1)
            val imageFile = File(imageLocation)
            if (imageFile.exists()) {   // TODO: is there a better way to do this?
                //val bm = BitmapFactory.decodeFile(imageLocation)
                //imageView.setImageBitmap(bm)
                Glide.with(this).load(imageFile).into(imageView)
            }   }
        if(cursor.move(6)){
            val imageView = findViewById(R.id.i7) as ImageView
            val imageLocation = cursor.getString(1)
            val imageFile = File(imageLocation)
            if (imageFile.exists()) {   // TODO: is there a better way to do this?
                //val bm = BitmapFactory.decodeFile(imageLocation)
                //imageView.setImageBitmap(bm)
                Glide.with(this).load(imageFile).into(imageView)
            } }
        if(cursor.move(7)){
            val imageView = findViewById(R.id.i8) as ImageView
            val imageLocation = cursor.getString(1)
            val imageFile = File(imageLocation)
            if (imageFile.exists()) {   // TODO: is there a better way to do this?
                //val bm = BitmapFactory.decodeFile(imageLocation)
                //imageView.setImageBitmap(bm)
                Glide.with(this).load(imageFile).into(imageView)
            } }



            if(cursor.move(cursor.count-1)){
            Log.v("존재","존재")
        }else{
            Log.v("부재","부재")

        }

        Log.v("커서", cursor.columnCount.toString())
        Log.v("커서2", cursor.count.toString())



        cursor.close()
    }

    fun changeImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE)
    }



    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == RESULT_OK) {
                try {
                    //if(ApplicationController.getInstance().is
                    this.data = data!!.data
                    val options = BitmapFactory.Options()

                    var input: InputStream? = null // here, you need to get your context.
                    try {
                        input = contentResolver.openInputStream(this.data)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }

                    val bitmap = BitmapFactory.decodeStream(input, null, options) // InputStream 으로부터 Bitmap 을 만들어 준다.
                    val baos = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos)
                    //val photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray())
                    val photo = File(data.toString()) // 가져온 파일의 이름을 알아내려고 사용합니다
                    Log.v("경로", photo.absolutePath)
                    val path = android.os.Environment.DIRECTORY_DCIM
                    Log.v("경로2", path)


                    val folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)

                    if (!folder.exists()) {
                        folder.mkdir()
                    }
                    Log.v("경로3", folder.absolutePath)



                    ///RequestBody photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray());
                    // MultipartBody.Part 실제 파일의 이름을 보내기 위해 사용!!
                    //profile_pic = MultipartBody.Part.createFormData("profileImg", photo.name, photoBody)
                    //body = MultipartBody.Part.createFormData("image", photo.getName(), profile_pic);

//                    Glide.with(this)
//                            .load(data.data)
//                            .centerCrop()
//                            .into(profile)

                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }

}
