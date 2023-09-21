package com.example.kotlintest.view

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.example.kotlintest.databinding.TitleBinding

class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    //https://blog.csdn.net/qq_45926462/article/details/128115748
    private var mBinding: TitleBinding

    init {
        mBinding = TitleBinding.inflate(LayoutInflater.from(context), this, true)
        mBinding.iconBack.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
        mBinding.tvTitle.setOnClickListener {
            Toast.makeText(context, "You clicked title", Toast.LENGTH_SHORT).show()
        }
    }
}
