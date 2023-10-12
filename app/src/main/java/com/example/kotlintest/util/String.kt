package com.example.kotlintest.util

/**
 * 扩展函数
 * String甚至还有reverse()函数用于反转字符串，capitalize()函数用于对首字母进行大写
 */
fun String.lettersCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count

//    fun ClassName.methodName(param1: Int, param2: Int): Int {
//        return 0
//    }
//    val count = "ABC123xyz!@#".lettersCount()

}

//operator fun String.times(n: Int): String {
//    val builder = StringBuilder()
//    repeat(n) {
//        builder.append(this)
//    }
//    return builder.toString()
//}

operator fun String.times(n: Int) = repeat(n)

fun main() {
    val string = "abc" * 3
    println(string)
}