package com.example.kotlintest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityFirstBinding
import com.example.kotlintest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val data = intent.getStringExtra("data")
        Log.d("SecondActivity", "data is $data")
        Toast.makeText(this, "data is $data", Toast.LENGTH_LONG)
            .show()
        mBinding.button2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data", data)
            setResult(RESULT_OK, intent)
            finish()
        }

        //https://www.coder.work/article/7874466
        onBackPressedDispatcher.addCallback(
            this, // lifecycle owner
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val intent = Intent()
                    intent.putExtra("data", data)
                    setResult(RESULT_OK, intent)
                    finish()
                }
            })
    }
}