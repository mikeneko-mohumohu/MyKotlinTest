package com.example.kmyou.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
//        val mManager : FragmentManager = supportFragmentManager
//        val mTransition : FragmentTransaction = mManager.beginTransaction()
//        mTransition.add(R.id.frame, MainFragment.getInstance())
//        mTransition.commit()
        val myPagerAdapter = MyPagerAdapter(supportFragmentManager)
        myPagerAdapter.add(MainFragment.getInstance())
        myPagerAdapter.add(MainFragment.getInstance())
        view_pager.adapter = myPagerAdapter

    }
}
