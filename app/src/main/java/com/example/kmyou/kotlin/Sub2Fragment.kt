package com.example.kmyou.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.fragment_sub_2.*

class Sub2Fragment : Fragment() {
    companion object {
        fun getInstance(): Sub2Fragment {
            return Sub2Fragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        return inflater.inflate(R.layout.fragment_sub_2,container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView.setWebViewClient(WebViewClient())
        webView.loadUrl("https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.browser/index.html")
    }
}
