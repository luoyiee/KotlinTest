package com.example.kotlintest.util


/**
 * 单例类替代 static 静态类
 * 会使所有方法静态化
 */
object Util {
    fun doAction() {
        println("Do action")
    }
}