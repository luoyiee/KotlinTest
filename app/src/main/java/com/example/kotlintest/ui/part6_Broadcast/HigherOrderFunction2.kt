package com.example.kotlintest.ui.part6_Broadcast


/**
 * 定义高阶函数完整的语法规则，在函数类型的前面加上ClassName. 就表示这个函数类型是定义在哪个类当中的
 * 类似 apply
 */
fun main() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().build {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(result.toString())
}


fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}