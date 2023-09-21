package com.example.kotlintest.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.kotlintest.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity() {

    private lateinit var mBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SecondActivity", "Task id is $taskId")
        mBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val data = intent.getStringExtra("data")
        Log.d("SecondActivity", "data is $data")
        Toast.makeText(this, "data is $data", Toast.LENGTH_LONG)
            .show()
        mBinding.goMain.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data", data)
            setResult(RESULT_OK, intent)
            finish()
        }

        //单例模式--新开一个栈--返回--
        mBinding.goThird.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
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

    /**
     * 相当于Java---public static
     */
    companion object {
        fun actionStart(context: Context, data1: String, data2: String) {
//            val intent = Intent(context,SecondActivity::class.java)
//            intent.putExtra("param1",data1)
//            intent.putExtra("param2",data2)
//            context.startActivity(intent)
            val intent = with(Intent(context, SecondActivity::class.java)) {
                putExtra("param1", data1)
                putExtra("param2", data2)
            }
//            val intent = Intent(context, SecondActivity::class.java).run {
//                putExtra("param1", data1)
//                putExtra("param2", data2)
//            }
//            val intent = Intent(context, SecondActivity::class.java).apply {
//                putExtra("param1", data1)
//                putExtra("param2", data2)
//            }
            context.startActivity(intent)
            //顶级方法调用【静态类
//            doWork()
        }
    }
}