package com.example.kotlintest.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.buttonToast.setOnClickListener(this)
        mBinding.buttonFinish.setOnClickListener(this)
        mBinding.buttonIntent.setOnClickListener(this)
        mBinding.buttonWeb.setOnClickListener(this)
        mBinding.buttonCall.setOnClickListener(this)
        mBinding.buttonExtra.setOnClickListener(this)
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
            mBinding.buttonToast -> Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT)
                .show()

            mBinding.buttonFinish -> finish()
            mBinding.buttonIntent -> {
                //SecondActivity::class.java的写法就相当于Java 中SecondActivity.class
                //显式Intent
//                val intent = Intent(this, SecondActivity::class.java)
//                startActivity(intent)
                //隐式Intent
                val intent = Intent("com.example.kotlintest.ACTION_START")
                intent.addCategory("com.example.kotlintest.MY_CATEGORY")
                startActivity(intent)
            }

            mBinding.buttonWeb -> {
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

            mBinding.buttonCall -> {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:10086")
                startActivity(intent)
            }

            mBinding.buttonExtra -> {
                val data = "Hello SecondActivity"
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("data", data)
//                startActivity(intent)
                startActivityForResult(intent, 1)
            }
        }
    }

    /**
     * requestCode请求码 resultCode结果码
     */

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnData=data?.getStringExtra("data")
                Log.d("FirstActivity", "return data is $returnData")
                Toast.makeText(this, "return data is $returnData", Toast.LENGTH_LONG)
                    .show()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}