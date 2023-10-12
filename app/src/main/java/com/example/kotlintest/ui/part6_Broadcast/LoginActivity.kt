package com.example.kotlintest.ui.part6_Broadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityLoginBinding
import com.example.kotlintest.ui.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.login.setOnClickListener {
            val account = mBinding.accountEdit.text.toString()
            val password = mBinding.passwordEdit.text.toString()
            // 如果账号是admin且密码是123456，就认为登录成功
            if (account == "admin" && password == "123456") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "account or password is invalid",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}