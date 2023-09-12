package com.example.kotlintest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityFirstBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}