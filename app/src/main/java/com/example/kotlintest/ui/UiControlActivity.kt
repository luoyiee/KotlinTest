package com.example.kotlintest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityUiControlBinding

class UiControlActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityUiControlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityUiControlBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.testEt.setOnClickListener(this)
        mBinding.testIv.setOnClickListener(this)
        mBinding.testVisibility.setOnClickListener(this)
        mBinding.testProgressbar.setOnClickListener(this)
        mBinding.testDialog.setOnClickListener(this)
        mBinding.testLayout.setOnClickListener(this)
        mBinding.testListView.setOnClickListener(this)
        mBinding.testRecyclerView.setOnClickListener(this)
//        mBinding.button.setOnClickListener {
//            // 在此处添加逻辑
//        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.test_et -> {
                val inputText = mBinding.editText.text.toString()
                Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show()
            }

            R.id.test_iv -> {
                mBinding.imageView.setImageResource(R.drawable.avatar_2)
            }

            R.id.test_visibility -> {
                if (mBinding.progressBar.visibility == View.VISIBLE) {
                    mBinding.progressBar.visibility = View.GONE
                } else {
                    mBinding.progressBar.visibility = View.VISIBLE
                }
            }

            R.id.test_progressbar -> {
                mBinding.progressBar.progress = mBinding.progressBar.progress + 10
            }

            R.id.test_dialog -> {
                AlertDialog.Builder(this).apply {
                    setTitle("This is Dialog")
                    setMessage("Something important.")
                    setCancelable(false)
                    setPositiveButton("OK") { dialog, which ->
                    }
                    setNegativeButton("Cancel") { dialog, which ->
                    }
                    show()
                }
            }

            R.id.test_layout -> {
                val intent = Intent(this, UiLayoutActivity::class.java)
                startActivity(intent)
            }
            R.id.test_list_view -> {
                val intent = Intent(this, ListViewActivity::class.java)
                startActivity(intent)
            }
            R.id.test_recycler_view -> {
                val intent = Intent(this, UiLayoutActivity::class.java)
                startActivity(intent)
            }
        }
    }
}