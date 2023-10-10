package com.example.kotlintest.ui.part5_Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityFragmentTestBinding

class FragmentTestActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityFragmentTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFragmentTestBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        //  https://blog.csdn.net/Annie_0321/article/details/131780763
        val button: Button = findViewById(R.id.left_button)
        button.setOnClickListener {
            replaceFragment(AnotherRightFragment())
        }
//        replaceFragment(RightFragment())
//Fragment 和Activity 之间的交互
//        val fragment = supportFragmentManager.findFragmentById(R.id.leftFrag) as LeftFragment
//        val fragment = mBinding.leftFrag
    }

    //    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.rightLayout, fragment)
//        transaction.commit()
//    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}