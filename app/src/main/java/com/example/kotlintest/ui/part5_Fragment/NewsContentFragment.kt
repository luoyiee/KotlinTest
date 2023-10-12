package com.example.kotlintest.ui.part5_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlintest.R
import com.example.kotlintest.databinding.NewsContentFragBinding

class NewsContentFragment : Fragment() {
    private lateinit var mBinding: NewsContentFragBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = NewsContentFragBinding.inflate(inflater)
        return mBinding.root
    }

    fun refresh(title: String, content: String) {
        mBinding.contentLayout.visibility = View.VISIBLE
        mBinding.newsTitle.text = title // 刷新新闻的标题
        mBinding.newsContent.text = content // 刷新新闻的内容
    }
}