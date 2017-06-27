package com.example.kmyou.kotlin

import android.os.AsyncTask
import android.util.Log
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.util.concurrent.TimeUnit
import okhttp3.FormBody



/**
 * Created by kmyou on 2017/05/22.
 */
class API {

    fun requestGet(url :String , callback: Callback) {
        Log.d("通信","呼び出しGET")
        val request : Request = Request.Builder()
                .url(url)
                .get()
                .build()

        val client : OkHttpClient = OkHttpClient().newBuilder()
                .readTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .connectTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .build()

        val asyncTask : AsyncTask<Void, Void, String> = object : AsyncTask<Void, Void, String>() {
            override fun doInBackground(vararg params: Void) : String? {
                Log.d("通信","実行")
                client.newCall(request).enqueue(callback)
                return null
            }
        }
        asyncTask.execute()
    }

    fun requestPost(url :String, callback: Callback) {
        Log.d("通信","呼び出しPOST")
        val formBody = FormBody.Builder()
                .add("tokyo", "130010")
                .add("osaka", "270000")
                .add("name", "nanashinogonbei")
                .add("action", "hoge")
                .add("value", "fuga")
                .build()

        var request : Request = Request.Builder()
                .url(url)
                .post(formBody)
                .build()

        var client : OkHttpClient = OkHttpClient().newBuilder()
                .readTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .connectTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .build()

        val asyncTask : AsyncTask<Void, Void, String> = object : AsyncTask<Void, Void, String>() {
            override fun doInBackground(vararg p0: Void?): String? {
                client.newCall(request).enqueue(callback)
                return null
            }
        }
        asyncTask.execute()
    }
}