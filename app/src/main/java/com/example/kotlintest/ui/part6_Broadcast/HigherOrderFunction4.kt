package com.example.kotlintest.ui.part6_Broadcast

/**
 *
 * 内联函数，我们就可以在Lambda 表达式中使用return关键字了
 */
//fun printString(str: String, block: (String) -> Unit) {
//    println("printString begin")
//    block(str)
//    println("printString end")
//}
//fun main() {
//    println("main start")
//    val str = ""
//    printString(str) { s ->
//        println("lambda start")
//        //局部返回
//        if (s.isEmpty()) return@printString
//        println(s)
//        println("lambda end")
//    }
//    println("main end")
//}

inline fun printString(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}
fun main() {
    println("main start")
    val str = ""
    printString(str) { s ->
        println("lambda start")
        //局部返回
        if (s.isEmpty()) return
        println(s)
        println("lambda end")
    }
    println("main end")
}
