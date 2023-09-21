package com.example.kotlintest.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityMainBinding

class MainActivity : BaseActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityMainBinding
    private val tag = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "Task id is $taskId")
        if (savedInstanceState != null) {
            val tempData = savedInstanceState.getString("data_key")
            Log.d(tag, "tempData is $tempData")
        }
        Log.d(tag, "onCreate")
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.btnToast.setOnClickListener(this)
        mBinding.btnFinish.setOnClickListener(this)
        mBinding.btnIntent.setOnClickListener(this)
        mBinding.btnWeb.setOnClickListener(this)
        mBinding.btnCall.setOnClickListener(this)
        mBinding.btnExtra.setOnClickListener(this)
        mBinding.btnLifeCycleActivity.setOnClickListener(this)
        mBinding.btnLifeCycleDialog.setOnClickListener(this)
        mBinding.btnLaunchMode.setOnClickListener(this)
        mBinding.btnUi.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT)
                .show()
        }
        return true
    }

    override fun onClick(v: View?) {
        when (v) {
            mBinding.btnToast -> Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT)
                .show()

            mBinding.btnFinish -> finish()
            mBinding.btnIntent -> {
                //SecondActivity::class.java的写法就相当于Java 中SecondActivity.class
                //显式Intent
//                val intent = Intent(this, SecondActivity::class.java)
//                startActivity(intent)
                //隐式Intent
//                val intent = Intent("com.example.kotlintest.ACTION_START")
//                intent.addCategory("com.example.kotlintest.MY_CATEGORY")
//                startActivity(intent)
                SecondActivity.actionStart(this, "param1", "param2")
            }

            mBinding.btnWeb -> {
                //android:scheme。用于指定数据的协议部分，如上例中的https 部分。
                //android:host。用于指定数据的主机名部分，如上例中的www.baidu.com 部分。
                //android:port。用于指定数据的端口部分，一般紧随在主机名之后。
                //android:path。用于指定主机名和端口之后的部分，如一段网址中跟在域名之后的内容。
                //android:mimeType。用于指定可以处理的数据类型，允许使用通配符的方式进行指定。
//                val intent = Intent(Intent.ACTION_VIEW)

                val intent = Intent()//需要指定action为空，不然无法跳转
                intent.data = Uri.parse("https://www.baidu.com")
                startActivity(intent)
            }

            mBinding.btnCall -> {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:10086")
                startActivity(intent)
            }

            mBinding.btnExtra -> {
                val data = "Hello SecondActivity"
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("data", data)
//                startActivity(intent)
                startActivityForResult(intent, 1)
            }

            mBinding.btnLifeCycleActivity -> {
                val intent = Intent(this, NormalActivity::class.java)
                startActivity(intent)
            }

            mBinding.btnLifeCycleDialog -> {
                val intent = Intent(this, DialogActivity::class.java)
                startActivity(intent)
            }

            mBinding.btnLaunchMode -> {
                //启动模式
                // standard一次新建一个实例
                // singleTop栈顶复用，不在栈顶会新建
                // singleTask栈内复用，只创建一个实例
//                val intent = Intent(this, FirstActivity::class.java)
//                startActivity(intent)
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }

            mBinding.btnUi -> {
                val intent = Intent(this, UiControlActivity::class.java)
                startActivity(intent)
            }
        }
    }

    /**
     * requestCode请求码 resultCode结果码
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnData = data?.getStringExtra("data")
                Log.d("FirstActivity", "return data is $returnData")
                Toast.makeText(this, "return data is $returnData", Toast.LENGTH_LONG)
                    .show()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
    }

    /**
     * Activity内存不足被回收，会重建
     * 恢复数据
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempData = "Something you just typed"
        outState.putString("data_key", tempData)
    }
}