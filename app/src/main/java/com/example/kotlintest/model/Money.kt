package com.example.kotlintest.model

class Money(val value: Int) {
//    operator fun plus(money: Money): Money {
//        val sum = value + money.value
//        return Money(sum)
//    }

    operator fun plus(newValue: Int): Money {
        val sum = value + newValue
        return Money(sum)
    }


    //    operator fun plus(money: Money): Money {
//        val sum = value + money.value * 7
//        return Money(sum)
//    }
    operator fun plus(money: Money): Money {
        val sum = value / 7 + money.value
        return Money(sum)
    }
}

fun main() {
    val money1 = Money(7)
    val money2 = Money(5)
    val money3 = money1 + money2
    val money4 = money3 + 30

    println(money3.value)
}