package com.example.kotlintest.util

/**
 * 运算符重载
 * operator关键字
 * 加号运算符对应的是plus()函数，减号运算符对应的是minus()函数。
 * 乘号运算符对应的是times()函数，除号运算符对应的是div()函数。
 * kotlin 既可以用成员函数重载操作符, 也可以用扩展函数重载操作符
 * https://blog.csdn.net/qq_30690165/article/details/125480474
 */
class Operate(val x: Int, val y: Int) {
    operator fun plus(other: Operate): Operate {
        return Operate(this.x + other.x, this.y + other.y)
    }

    override fun toString(): String {
        return "Point{x = $x, y = $y}"
    }

    //可以定义扩展函数的操作符重载 ★
    operator fun Operate.plus(other: Operate): Operate {
        return Operate(this.x + other.x, this.y + other.y)
    }

    operator fun Operate.times(d: Double): Operate {
        return Operate((this.x * d).toInt(), (this.y * d).toInt())
    }

}

fun main() {
    val point2 = Operate(1, 2) + Operate(3, 4)
    println(point2)
//    println(p * 1.5)
}
