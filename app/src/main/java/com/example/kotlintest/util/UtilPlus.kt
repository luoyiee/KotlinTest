package com.example.kotlintest.util


/**
 * 单例类替代 static 静态类
 * 会使所有方法静态化
 */
class UtilPlus {

    /**
     * 内部类
     */
    fun doAction() {
        println("doAction")
    }

    /**
     * 伴生类--类似静态类
     * 注解@JvmStatic--静态类，不加伴生类
     * 顶层方法
     */
    companion object{
        @JvmStatic
        fun watchTv() {
            println("watchTv")
        }
    }
}