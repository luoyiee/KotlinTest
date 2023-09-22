package com.example.kotlintest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kotlintest.R
import com.example.kotlintest.adapter.FruitRvAdapter
import com.example.kotlintest.adapter.FruitRvFallAdapter
import com.example.kotlintest.adapter.FruitRvHonAdapter
import com.example.kotlintest.databinding.ActivityRecyclerViewBinding
import com.example.kotlintest.model.Fruit

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityRecyclerViewBinding
    private val fruitListV = ArrayList<Fruit>()
    private val fruitListH = ArrayList<Fruit>()
    private val fruitListF = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initView()
    }

    private fun initView() {
        initAdapterV()
        initAdapterH()
        initAdapterF()
    }

    private fun initAdapterV() {
        initFruits(fruitListV) // 初始化水果数据
        val layoutManager = LinearLayoutManager(this)
        mBinding.recyclerViewVertical.layoutManager = layoutManager
//        mBinding.recyclerViewFall.hasFixedSize()
//        mBinding.recyclerViewFall.isNestedScrollingEnabled = true
        val adapter = FruitRvAdapter(fruitListV)
        mBinding.recyclerViewVertical.adapter = adapter
    }

    private fun initAdapterH() {
        initFruits(fruitListH) // 初始化水果数据
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        mBinding.recyclerViewHorizontal.layoutManager = layoutManager
        val adapter = FruitRvHonAdapter(fruitListH)
        mBinding.recyclerViewHorizontal.adapter = adapter
    }

    private fun initAdapterF() {
        initFruitsFall() // 初始化水果数据
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        mBinding.recyclerViewFall.layoutManager = layoutManager
//        mBinding.recyclerViewFall.hasFixedSize()
//        mBinding.recyclerViewFall.isNestedScrollingEnabled = true
        val adapter = FruitRvFallAdapter(fruitListF)
        mBinding.recyclerViewFall.adapter = adapter
    }

    private fun initFruits(fruitList:ArrayList<Fruit>) {
        repeat(2) {
            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
            fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
            fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
            fruitList.add(Fruit("Mango", R.drawable.mango_pic))
        }
    }


    private fun initFruitsFall() {
        repeat(2) {
            fruitListF.add(Fruit(getRandomLengthString("Apple"),
                R.drawable.apple_pic))
            fruitListF.add(Fruit(getRandomLengthString("Banana"),
                R.drawable.banana_pic))
            fruitListF.add(Fruit(getRandomLengthString("Orange"),
                R.drawable.orange_pic))
            fruitListF.add(Fruit(getRandomLengthString("Watermelon"),
                R.drawable.watermelon_pic))
            fruitListF.add(Fruit(getRandomLengthString("Pear"),
                R.drawable.pear_pic))
            fruitListF.add(Fruit(getRandomLengthString("Grape"),
                R.drawable.grape_pic))
            fruitListF.add(Fruit(getRandomLengthString("Pineapple"),
                R.drawable.pineapple_pic))
            fruitListF.add(Fruit(getRandomLengthString("Strawberry"),
                R.drawable.strawberry_pic))
            fruitListF.add(Fruit(getRandomLengthString("Cherry"),
                R.drawable.cherry_pic))
            fruitListF.add(Fruit(getRandomLengthString("Mango"),
                R.drawable.mango_pic))
        }
    }

    private fun getRandomLengthString(str: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }
}