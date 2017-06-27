package com.example.kmyou.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*
import android.widget.Toast
import android.widget.*
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class SecondActivity : AppCompatActivity() {
    val TAG : String? = SecondActivity::class.simpleName
    val url = "http://weather.livedoor.com/forecast/webservice/json/v1?city=400040"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initialize()
    }
    fun initialize() {
        val text = intent.getStringExtra("EXT")
        modoru.setOnClickListener { finish() }
        button.setOnClickListener {
            Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ThirdActivity::class.java).setAction(Intent.ACTION_VIEW)
            startActivity(intent)
        }
        val animals = listOf("Rabbit", "Dog", "Cat", "Turtle", "Bear", "Dolphin", "Lion", "Tiger")
        val person : Person = Person("namae", "namae2", 11)
        val personList : ArrayList<Person> = arrayListOf(person)
        for(i in 0 until 20) {
            val personData = Person("name","name2",10)
            personData.elapse(i)
            personList.add(personData)
        }
        val adapter = ListAdapter(this, personList)
        list_view.adapter = adapter
        getWether()
    }

    fun getWether() {
        Log.d(TAG,"実行")
        val api = API()
        api.requestGet(url, myCallBack())
    }

    fun myCallBack() : Callback {
        return object : Callback {
            override fun onFailure(call : Call, e : IOException){
                Log.d(TAG,"しっぱい")
            }
            override fun onResponse(call : Call, response: Response) {
                val jsonData : String  = response.body().string()
                Log.d(TAG,"成功"+jsonData)
            }
        }
    }
}
