package com.yg.dialogcustom

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var customDialog : DialogCustom? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            //savedInstanceState 동일한 액티비티가 재실행 될 때 저장된 값이 있는지 판단!
            //물론 이 예제에서 다루지 않을것이지만 다룬다 하여도 최초실행시에는 저장된 것이 없겠죠??
        if(savedInstanceState == null) {
            val bundle = Bundle()
            bundle.putString("title", button!!.text.toString())
            AddFragment(MainFragment(), bundle, "aaa")
        }


        button.setOnClickListener {
            floatingDialog()
        }

        for(i in 0..95){

        }

        //Anima
    }

    fun floatingDialog() {
        val content = "다이얼로그입니당?"
        customDialog = DialogCustom(this, content, addLeftListener, addRightListener, "취소", "추가")
        //customDialog!!.window.setGravity(Gravity.CENTER_VERTICAL)

        val window = customDialog!!.window
        val wlp = window.attributes
        wlp.gravity = Gravity.BOTTOM //wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.attributes = wlp
        customDialog!!.show()
    }

    private val addLeftListener : View.OnClickListener? = View.OnClickListener {
        customDialog!!.dismiss()
    }

    private val addRightListener : View.OnClickListener? = View.OnClickListener {
        customDialog!!.dismiss()
    }

    fun AddFragment(fragment: Fragment, bundle: Bundle, tag: String) {            //오버라이딩하여 최초에 추가될 프레그먼트 생성함수
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.add(R.id.frame, fragment, tag)
        //transaction.addToBackStack(null);
        transaction.commit()
    }


//    fun AddFragment(fragment: Fragment) {            //오버라이딩하여 최초에 추가될 프레그먼트 생성함수
//        val fm = supportFragmentManager
//        val transaction = fm.beginTransaction()
//        transaction.add(R.id.frame, fragment)
//        //transaction.addToBackStack(null);
//        transaction.commit()
//    }


}
