package com.example.kotlintest.ui.part5_Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlintest.databinding.FragmentLeftBinding

class LeftFragment : Fragment() {
    private lateinit var mBinding: FragmentLeftBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentLeftBinding.inflate(inflater)
        return mBinding.root
    }

//    onAttach()：当Fragment 和Activity 建立关联时调用。
//    onCreateView()：为Fragment 创建视图（加载布局）时调用。
//    onActivityCreated()：确保与Fragment 相关联的Activity 已经创建完毕时调用。
//    onDestroyView()：当与Fragment 关联的视图被移除时调用。
//    onDetach()：当Fragment 和Activity 解除关联时调用。

}