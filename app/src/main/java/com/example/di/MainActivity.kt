package com.example.di

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val myViewModel by viewModel<MyViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myViewModel.advice.observe(this, Observer { advice -> updateAdvice(advice)})

        swipe_refresh.setOnRefreshListener {
            myViewModel.fetchAdvice()
        }
    }

    private fun updateAdvice (advice: String) {
        swipe_refresh.isRefreshing = false
        advice_txt.text = advice
    }
}
