package com.example.kotlintest

/**
 * Kotlin中我们不需要私有化构造函数，也不需要提供getInstance()这样的静态方法，只需要把class关键字改成object关键字，一个单例类就创建完成了
 */
object Singleton {
    fun singletonTest() {
        println("singletonTest is called.")
    }
}