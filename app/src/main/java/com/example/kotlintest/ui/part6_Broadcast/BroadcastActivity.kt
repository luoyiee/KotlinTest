package com.example.kotlintest.ui.part6_Broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityBroadcastBinding
import com.example.kotlintest.ui.BaseActivity

/**
 * 动态注册BroadcastReceiver
 * 必须在程序启动之后才能接收广播
 * 不允许开启线程
 */
class BroadcastActivity : BaseActivity() {
    private lateinit var mBinding: ActivityBroadcastBinding
    lateinit var timeChangeReceiver: TimeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityBroadcastBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val intentFilter = IntentFilter()
        //当系统时间发生变化时,系统每隔一分钟就会发出一条android.intent.action.TIME_TICK的广播
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
//        registerReceiver(timeChangeReceiver, intentFilter)
        mBinding.button.setOnClickListener {
            //标准广播
//            val intent = Intent("com.example.broadcasttest.MY_BROADCAST")
//            intent.setPackage(packageName)
//            sendBroadcast(intent)
            //有序广播
            val intent = Intent("com.example.broadcasttest.MY_BROADCAST")
            intent.setPackage(packageName)
            sendOrderedBroadcast(intent, null)
        }
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context, "Time has changed", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }
}