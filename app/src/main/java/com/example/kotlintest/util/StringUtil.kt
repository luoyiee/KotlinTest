package com.example.kotlintest.util

object StringUtil {
    fun lettersCount(str: String): Int {
        var count = 0
        for (char in str) {
            if (char.isLetter()) {
                count++
            }
        }
        return count
    }
//    val str = "ABC123xyz!@#"
//    val count = StringUtil.lettersCount(str)
}

//fun main() {
//
//}