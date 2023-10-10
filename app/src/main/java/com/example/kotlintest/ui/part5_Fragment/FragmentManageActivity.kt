package com.example.kotlintest.ui.part5_Fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityFragmentManageBinding
import com.example.kotlintest.databinding.ActivityFragmentTestBinding
import com.example.kotlintest.databinding.ActivityMainBinding
import com.example.kotlintest.ui.BaseActivity
import com.example.kotlintest.ui.part3_Activity.SecondActivity

class FragmentManageActivity : BaseActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityFragmentManageBinding
    private val tag = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFragmentManageBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.btnFragmentLife.setOnClickListener(this)
        mBinding.btnFragmentQualifier.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            mBinding.btnFragmentLife ->
                startActivity(Intent(this, FragmentTestActivity::class.java))

            mBinding.btnFragmentQualifier -> {
//                startActivity(Intent(this, FragmentQualifierActivity::class.java))
            }
        }
    }
}