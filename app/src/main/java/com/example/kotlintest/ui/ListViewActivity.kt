package com.example.kotlintest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityListViewBinding

    private val data = listOf(
        "Apple", "Banana", "Orange", "Watermelon",
        "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
        "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape",
        "Pineapple", "Strawberry", "Cherry", "Mango"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        mBinding.listView.adapter = adapter
    }
}