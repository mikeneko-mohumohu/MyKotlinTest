package com.example.kmyou.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    val TAG : String? = MainActivity::class.simpleName
    val url = "http://api.openweathermap.org/data/2.5/weather?APPID=<自身のAPPID>&q=Tokyo"
    val a = "定数"
    var s: String = "abc"
    val t: String = "xyz"
    val b = 43
    val c = b.toString()
    val d = if (b < 42) {
        "sm"
    } else {
        "bi"
    }
    val e = when (b) {
        0 -> "humohumo"
        1,2 ->"hugahuga"
        else -> "hogehoge"
    }
    val person = Person("namae", "namae2", 11)
    val myList: MutableList<Int> = mutableListOf()
    val myArray = intArrayOf(2,3,5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        a = 2
        initialize()
    }

    fun initialize(){
        println("initialize" + c)
        hello.text = "Hello world" + a + s + t
        buttonPanel.setOnClickListener { println("click") }
        buttonPanel2.setOnClickListener { nextActivity() }

        println(d)

        for (i in 0 until 100) {
            println("count+" + i)
        }
        for (i in 99 downTo 0) println(i) // for (int i = 99; i >= 0; i--)
        for (i in 0 until 100 step 2) println(i) // for (int i = 0; i < 100; i += 2)
        for (i in 1..100) println(i) // for (int i = 1; i <= 100; i++)
        println(e)
        println(person.age)
        println(person.getFullName)
        person.elapse(5)
        println(person.age)
        myList.add(2)
        myList.add(3)
        myList.add(5)
        for (my in myList) {
            println(my)
        }
        for (value in myArray) {
            println(value)
        }
        getWether()
    }

    fun nextActivity() {
        Log.d(TAG,"next!")
        val intent = Intent(this, SecondActivity::class.java).setAction(Intent.ACTION_VIEW)
        intent.putExtra("EXT","next")
        startActivity(intent)
    }
    fun getWether() {
        Log.d(TAG,"実行")
        val api = API()
        api.requestGet(url, myCallBack())
    }

    fun myCallBack() : Callback{
        return object : Callback {
            override fun onFailure(call : Call, e : IOException){
                Log.d(TAG,"しっぱい")
            }
            override fun onResponse(call : Call, response: Response) {
                Log.d(TAG,"成功")
            }
        }
    }
}
