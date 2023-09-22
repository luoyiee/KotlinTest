package com.example.kotlintest.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlintest.R
import com.example.kotlintest.adapter.FruitListAdapter
import com.example.kotlintest.databinding.ActivityListViewBinding
import com.example.kotlintest.model.Fruit

class ListViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityListViewBinding

    private val data = listOf(
        "Apple", "Banana", "Orange", "Watermelon",
        "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
        "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
        "Pineapple", "Strawberry", "Cherry", "Mango"
    )

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initView()
    }

    private fun initView() {
        initAdapter2()
    }

    private fun initAdapter1() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        mBinding.listView.adapter = adapter
    }

    private fun initAdapter2() {
        initFruits() // 初始化水果数据
        val adapter = FruitListAdapter(this, R.layout.fruit_item, fruitList)
        mBinding.listView.adapter = adapter
//        mBinding.listView.setOnItemClickListener { _, _, position, _ ->
//            val fruit = fruitList[position]
//            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
//        }
        mBinding.listView.setOnItemClickListener { parent, view, position, id ->
            val fruit = fruitList[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits() {
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

}