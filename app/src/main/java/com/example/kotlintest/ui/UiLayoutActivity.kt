package com.example.kotlintest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintest.R

class UiLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_layout)
        supportActionBar?.hide()
    }
}