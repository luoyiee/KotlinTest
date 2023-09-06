package com.example.kotlintest

import com.example.kotlintest.ui.Cellphone
import java.lang.Integer.max


/**
 * 参考 https://blog.csdn.net/liujun3512159/article/details/130960925
 * main函数要写在类的外面
 * Kotlin 中 public 修饰符是默认项，而在Java 中 default才是默认项

 * 修饰符        Java                              Kotlin
 * public    所有类可见                           所有类可见（默认）
   private   当前类可见                          当前类可见
  protected  当前类、子类、同一包路径下的类可见       当前类、子类可见
  default   同一包路径下的类可见（默认）             无
  internal   无                                 同一模块中的类可见
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
    rangeIn()
    rangeUntil()
    rangeDownTo()

    val student = Student("Jack", 19)
    //    val student1 = Student()
//    val student2 = Student("Jack", 19)
//    val student3 = Student("a123", 5, "Jack", 19)
    doStudy(student)

    val cellphone1 = Cellphone("Samsung", 1299.99)
    val cellphone2 = Cellphone("Samsung", 1299.99)
    println(cellphone1)
    println("cellphone1 equals cellphone2 " + (cellphone1 == cellphone2))
    Singleton.singletonTest()
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

/**
 * 循环语句
 * in 左右闭合 until 左闭右开 step 跳过元素 downTo 降序
 *
 */
fun rangeIn() {
    for (i in 0..5) {
        println(i);
    }
}

fun rangeUntil() {
    for (i in 0 until 10 step 2) {
        println(i);
    }
}


fun rangeDownTo() {
    for (i in 20 downTo 15) {
        println(i);
    }
}

fun doStudy(study: Study) {
    study.watchTv()
    study.readBook()
}


















