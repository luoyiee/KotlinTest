package com.example.kotlintest

class NullTest {
    fun getTextLength(text: String?): Int {
        if (text != null) {
            return text.length
        }
        return 0
    }

    /**
     * ?就表示可为空
     * ?.为空不做操作
     * ?:三元运算
     * 非空断言工具!!
     */
    fun getTextLengthPlus(text: String?): Int {
        return text?.length ?: 0
    }
}

var content: String? = "hello"
fun main() {
    if (content != null) {
        printUpperCase()
    }
}

//fun printUpperCase() {
//    val upperCase = content.uppercase()
//    println(upperCase)
//}


/**
 * 非空断言工具!!
 */
fun printUpperCase() {
    val upperCase = content!!.uppercase()
    println(upperCase)
}