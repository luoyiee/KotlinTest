package com.example.kotlintest.ui.part6_Broadcast


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