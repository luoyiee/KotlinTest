package com.example.kotlintest.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.kotlintest.databinding.ActivityThirdBinding
import com.example.kotlintest.util.ActivityCollector

class ThirdActivity : BaseActivity() {

    private lateinit var mBinding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ThirdActivity", "Task id is $taskId")
        mBinding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        //退出App
        mBinding.exit.setOnClickListener {
            ActivityCollector.finishAll()
//            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }
}