package com.example.kotlintest.ui.part5_Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintest.R
import com.example.kotlintest.databinding.NewsContentFragBinding
import com.example.kotlintest.databinding.NewsTitleFragBinding
import com.example.kotlintest.model.News
import com.example.kotlintest.util.times

class NewsTitleFragment : Fragment() {
    private var isTwoPane = false
    private lateinit var mBinding: NewsTitleFragBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = NewsTitleFragBinding.inflate(inflater)
        return mBinding.root
    }

    private fun initView() {
        isTwoPane = activity?.findViewById<View>(R.id.newsContentLayout) != null
//        val frameLayout: FrameLayout? = activity?.findViewById(R.id.newsContentLayout)
//        isTwoPane = frameLayout != null
        val layoutManager = LinearLayoutManager(activity)
        mBinding.newsTitleRecyclerView.layoutManager = layoutManager
        val adapter = NewsAdapter(getNews())
        mBinding.newsTitleRecyclerView.adapter = adapter
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        isTwoPane = activity?.findViewById<View>(R.id.newsContentLayout) != null
//    }

//    override fun onViewStateRestored(savedInstanceState: Bundle?) {
//        super.onViewStateRestored(savedInstanceState)
//        initView()
//    }

    override fun onResume() {
        super.onResume()
        initView()
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    private fun getNews(): List<News> {
        val newsList = ArrayList<News>()
        for (i in 1..50) {
            val news = News("This is news title $i", getRandomLengthString("This is news content $i. "))
            newsList.add(news)
        }
        return newsList
    }

//    private fun getRandomLengthString(str: String): String {
//        val n = (1..20).random()
//        val builder = StringBuilder()
//        repeat(n) {
//            builder.append(str)
//        }
//        return builder.toString()
//    }

    private fun getRandomLengthString(str: String) = str * (1..20).random()


    inner class NewsAdapter(val newsList: List<News>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
            val holder = ViewHolder(view)
            holder.itemView.setOnClickListener {
                val news = newsList[holder.adapterPosition]
                if (isTwoPane) {
                    // 如果是双页模式，则刷新NewsContentFragment中的内容
//                    val fragment = newsContentFrag as NewsContentFragment
                    val fragment =
                        activity?.supportFragmentManager?.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
                    fragment.refresh(news.title, news.content)
                } else {
                    // 如果是单页模式，则直接启动NewsContentActivity
                    NewsContentActivity.actionStart(parent.context, news.title, news.content)
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }

        override fun getItemCount() = newsList.size
    }
}