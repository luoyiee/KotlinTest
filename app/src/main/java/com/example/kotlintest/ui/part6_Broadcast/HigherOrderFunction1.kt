package com.example.kotlintest.ui.part6_Broadcast

fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}

/**
 * 内联函数
 * noinline取消内联
 * 可使用return
 */
inline fun num1AndNum2Plus(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}
fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}

//fun main() {
//    val num1 = 100
//    val num2 = 80
//    //函数引用方式的写法
//    val result1 = num1AndNum2(num1, num2, ::plus)
//    val result2 = num1AndNum2(num1, num2, ::minus)
//    println("result1 is $result1")
//    println("result2 is $result2")
//}

fun main() {
    val num1 = 100
    val num2 = 80
    val result1 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 + n2
    }
//    val result2 = num1AndNum2(num1, num2) { n1, n2 ->
//        n1 - n2
//    }
//    println("result1 is $result1")
//    println("result2 is $result2")
//    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
//    val result = StringBuilder().build {
//        append("Start eating fruits.\n")
//        for (fruit in list) {
//            append(fruit).append("\n")
//        }
//        append("Ate all fruits.")
//    }
//    println(result.toString())
}

/**
 * 定义高阶函数完整的语法规则，在函数类型的前面加上ClassName. 就表示这个函数类型是定义在哪个类当中的
 * 类似 apply
 */
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}