package com.example.kotlintest

import java.lang.Integer.max


/**
 * 参考 https://blog.csdn.net/liujun3512159/article/details/130960925
 * main函数要写在类的外面
 */
class LearnKotlin

fun main() {
    println("test0 " + "Hello Kotlin");
    test1()
    test2()
    largeNum(111, 100)
    getScoreIf("TTT")
    getScoreWhen("TTT")
    checkNumber(10L)
}


/**
 * val不可变 final 优先使用
 * val可变
 */
fun test1() {
    val a = 10;
//    println("test1 " + "a= " + a)
    println("test1 a= $a")
}


fun test2() {
    var a: Int = 10;
    a = a * 10
    println("test2 a= $a")
}

//fun method(param1: Int, param2: Int): Int {
//    return 0;
//}

fun largeNum(num1: Int, num2: Int): Int {
    println("largeNum " + max(num1, num2))
    return max(num1, num2)
}

/**
 * 语法糖
 */
fun largeNum1(num1: Int, num2: Int): Int = max(num1, num2)
fun largeNum2(num1: Int, num2: Int) = max(num1, num2)

fun largeNum3(num1: Int, num2: Int): Int {
    var value = 0;
    if (num1 > num2) {
        value = num1
    } else {
        value = num2
    }
    return value
}

fun largeNum4(num1: Int, num2: Int): Int {
    val value = if (num1 > num2) {
        num1
    } else {
        num2
    }
    return value
}

fun largeNum5(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        num1
    } else {
        num2
    }
}

fun largeNum6(num1: Int, num2: Int) = if (num1 > num2) num1 else num2


fun getScoreIf(name: String) =
    if ("Tom".equals(name)) {
        90
    } else if ("Mary".equals(name)) {
        88
    } else {
        println("getScore " + 99)
        99
    }

fun getScoreWhen(name: String) = when (name) {
    "Tom" -> 88
    "Mary" -> 888
    else -> 199
}

fun getScoreWhen1(name: String) = when {
    name == "Tom" -> 88
    name == "Mary" -> 888
    else -> 199
}


/**
 * is关键字就是类型匹配的核心，它相当于Java 中的instanceof关键字
 * Number 子类Int、Long、Float、Double
 */
fun checkNumber(num: Number) = when (num) {
    is Int -> println("number is  Int")
    is Double -> println("number is  Double")
    else -> println("number is  unknown type")
}


















