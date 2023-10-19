package com.example.kotlintest.ui.part6_Broadcast

/**
 * 高阶函数
 * 函数类型添加到某个函数的参数声明或者返回值声明上
 * ->左边的部分就是用来声明该函数接收什么参数
 * ->右边的部分用于声明该函数的返回值是什么类型，如果没有返回值就使用Unit，它大致相当于Java中的void
 * (String, Int) -> Unit
 * 可使用return
 */
fun example(func: (String, Int) -> Unit) {
    func("hello", 123)
}

fun num1AndNum(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}

fun main() {
    val num1 = 100
    val num2 = 80
    //函数引用方式的写法,将plus()和minus()函数作为参数传递给 num1AndNum2()函数
    val result1 = num1AndNum(num1, num2, ::plus)
    val result2 = num1AndNum(num1, num2, ::minus)

    //Lambda表达式的写法
//    val result1 = num1AndNum(num1, num2) { n1, n2 ->
//        n1 + n2
//    }
//    val result2 = num1AndNum(num1, num2) { n1, n2 ->
//        n1 - n2
//    }
    println("result1 is $result1")
    println("result2 is $result2")
}