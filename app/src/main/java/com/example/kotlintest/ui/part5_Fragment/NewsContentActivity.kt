package com.example.kotlintest.ui.part5_Fragment

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityNewsContentBinding

class NewsContentActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityNewsContentBinding

    companion object {
        fun actionStart(context: Context, title: String, content: String) {
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra("news_title", title)
                putExtra("news_content", content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityNewsContentBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val title = intent.getStringExtra("news_title") // 获取传入的新闻标题
        val content = intent.getStringExtra("news_content") // 获取传入的新闻内容
        if (title != null && content != null) {
            //val fragment = newsContentFrag as NewsContentFragment
            val fragment =
                supportFragmentManager.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
            fragment.refresh(title, content) //刷新NewsContentFragment界面
        }
    }
}