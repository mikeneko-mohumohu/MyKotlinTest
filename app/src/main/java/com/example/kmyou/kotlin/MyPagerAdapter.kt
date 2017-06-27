package com.example.kmyou.kotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by kmyou on 2017/05/22.
 */
class MyPagerAdapter(myFragmentManager : FragmentManager) : FragmentPagerAdapter(myFragmentManager) {
    val myFragments = ArrayList<Fragment>()
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        val fragment = myFragments[position]
        return fragment
    }

    fun add(fragment: Fragment) {
        myFragments.add(fragment)
    }
}