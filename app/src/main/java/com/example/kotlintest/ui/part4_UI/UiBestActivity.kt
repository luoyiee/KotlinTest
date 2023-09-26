package com.example.kotlintest.ui.part4_UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlintest.adapter.MsgAdapter
import com.example.kotlintest.databinding.ActivityUiBestBinding
import com.example.kotlintest.model.Msg


class UiBestActivity : AppCompatActivity(), View.OnClickListener {
    private val msgList = ArrayList<Msg>()

    //private var adapter: MsgAdapter? = null
    //lateinit--对变量延迟初始化,需保证使用前已经初始化
    private lateinit var adapter: MsgAdapter
    private lateinit var mBinding: ActivityUiBestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityUiBestBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initAdapter()
    }

    private fun initAdapter() {
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        mBinding.recyclerView.layoutManager = layoutManager
        //判断变量是否初始化
        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }
        mBinding.recyclerView.adapter = adapter
        mBinding.send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            mBinding.send -> {
                val content = mBinding.inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
//                    adapter?.notifyItemInserted(msgList.size - 1) // 当有新消息时，刷新RecyclerView中的显示
                    adapter.notifyItemInserted(msgList.size - 1) // 当有新消息时，刷新RecyclerView中的显示
                    mBinding.recyclerView.scrollToPosition(msgList.size - 1) // 将RecyclerView定位到最后一行
                    mBinding.inputText.setText("") // 清空输入框中的内容
                }
            }
        }
    }

    private fun initMsg() {
        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}