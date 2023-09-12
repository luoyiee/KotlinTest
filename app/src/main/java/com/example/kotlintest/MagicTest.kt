package com.example.kotlintest

class MagicTest {
}

fun main() {
    magicTest()
    printParams(666, "test")
    printParams(666)
//    printParamsFront("JJJ")
    printParamsFront(str = "JJJ")
    printParamsFront(num = 888, str = "KKK")
}

fun magicTest() {
    val name = "Tom"
    val age = 18
    println("Test(name=$name,age=$age)")
}

fun printParams(num: Int, str: String = "hello") {
    println("num is $num,str is $str)")
}

fun printParamsFront(num: Int = 999, str: String) {
    println("num is $num,str is $str)")
}