package com.example.kmyou.kotlin

//import android.app.Fragment
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    companion object {
        fun getInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        return inflater.inflate(R.layout.fragment_main,container, false)
    }
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val mFragmentManager : FragmentManager = childFragmentManager

        val mFragmentTransaction : FragmentTransaction = mFragmentManager.beginTransaction()

        mFragmentTransaction.add(R.id.frame, SubFragment.getInstance())

        mFragmentTransaction.commit()


        button.setOnClickListener {
            Log.d("おしたよ","おしたよ")
            val mSFragmentManager : FragmentManager = childFragmentManager
            val mSFragmentTransaction : FragmentTransaction = mSFragmentManager.beginTransaction()
            mSFragmentTransaction.replace(R.id.frame, Sub2Fragment.getInstance())
            mSFragmentTransaction.commit()
        }
    }
}
