package com.example.kotlintest.ui

/**
 * data这个关键字，当在一个类前面声明了data关键字时，就表明你希望这个类是一个数据类，Kotlin会根据主构造函数中的参数帮你将equals()、hashCode()、toString()等固定且无实际逻辑意义的方法自动生成。
 */
data class Cellphone(val brand: String, val price: Double)




