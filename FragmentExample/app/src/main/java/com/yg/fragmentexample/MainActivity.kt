package com.yg.fragmentexample
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AddFragment()

    }

    fun AddFragment() {
        val fm = fragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_container, ParentFragment(), "Parent")
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
