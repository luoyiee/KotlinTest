package com.example.kotlintest

class LambdaTest {

    /**
     * Java写法
     * listOf不可变集合
     * mutableListOf可变集合
     */
    fun test() {
        val list = ArrayList<String>()
        list.add("Apple")
        list.add("Banana")
        list.add("Orange")
        list.add("Pear")
        list.add("Grape")
    }

    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
}

fun main() {
//    testListAdd();
//    testMapPlus()
//    testMapAdd()
//    testUppercase()
//    testFilter()
//    testAll()
//    testJavaApi()
    testWith()
}

fun testList() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    for (fruit in list) {
        println(fruit)
    }
}


fun testListAdd() {
    val list = mutableListOf("Apple", "Banana", "Orange", "Pear", "Grape")
    list.add("Watermelon")
    for (fruit in list) {
        println(fruit)
    }
}

/**
 * with函数
 * val result = with(obj){"value"}
 */
fun testAppend() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val builder = StringBuilder()
    builder.append("Start eat fruits").append("\n")
    for (fruit in list) {
        builder.append(fruit).append("\n")
    }
    builder.append("ate all fruits")
    println(builder.toString())
}

fun testWith() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = with(StringBuilder()) {
        append("Start eat fruits").append("\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("ate all fruits")
        toString()
    }
    println(result)
}

/**
 * run函数
 * val result = obj.run("value")
 */
fun testRun() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().run {
        append("Start eat fruits").append("\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("ate all fruits")
        toString()
    }
    println(result)
}

/**
 * apply函数
 * val result = obj.apply("value")
 * 只返回同类型
 */
fun testApply() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().apply {
        append("Start eat fruits").append("\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("ate all fruits")
//        toString()
    }
    println(result.toString())
}

/**
 * setOf不可变集合
 * mutableSetOf可变集合
 * Set集合中是不可以存放重复元素的
 */
fun testSet() {
    val set = setOf("Apple", "Banana", "Orange", "Pear", "Grape")
    for (fruit in set) {
        println(fruit)
    }
}

fun testSetAdd() {
    val set = mutableSetOf("Apple", "Banana", "Orange", "Pear", "Grape")
    set.add("Watermelon")
    for (fruit in set) {
        println(fruit)
    }
}

/**
 * java写法
 */
fun testMap() {
    val map = HashMap<String, Int>()
//        map.put("Apple", 1)
//        map.put("Banana", 2)
//        map.put("Orange", 3)
//        map.put("Pear", 4)
//        map.put("Grape", 5)
    map["Apple"] = 1
    map["Banana"] = 2
    map["Orange"] = 3
    map["Pear"] = 4
    map["Grape"] = 5
}

/**
 * to--infix函数
 */
fun testMapPlus() {
    val map = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    for ((fruit, number) in map) {
        println("fruit is " + fruit + ", number is " + number)
    }
}

fun testMapAdd() {
    val map = mutableMapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    map["Test"] = 6
    for (fruit in map) {
        println(fruit)
    }
}

fun testApi() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    var maxLengthFruit = ""
    for (fruit in list) {
        if (fruit.length > maxLengthFruit.length) {
            maxLengthFruit = fruit
        }
    }
    println("max length fruit is " + maxLengthFruit)
}

/**
 * Lambda 表达式的语法结构
 * {参数名1: 参数类型, 参数名2: 参数类型 -> 函数体}
 */
fun testApiPlus() {
//    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
//    val maxLengthFruit = list.maxBy { it.length }
//    println("max length fruit is " + maxLengthFruit)

    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
//    val lambda = { fruit: String -> fruit.length }
//    val maxLengthFruit = list.maxBy(lambda)
//    val maxLengthFruit = list.maxBy({ fruit: String -> fruit.length })
//    val maxLengthFruit = list.maxBy() { fruit: String -> fruit.length }
//    val maxLengthFruit = list.maxBy { fruit -> fruit.length }
    val maxLengthFruit = list.maxBy { it.length }
}

fun testUppercase() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    val newList = list.map { it.uppercase() }
    for (fruit in newList) {
        println(fruit)
    }
}

/**
 * 过滤集合中的数据
 */
fun testFilter() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    val newList = list.filter { it.length <= 5 }
        .map { it.uppercase() }
    for (fruit in newList) {
        println(fruit)
    }
}

/**
 * any函数用于判断集合中是否至少存在一个元素满足指定条件
 * all函数用于判断集合中是否所有元素都满足指定条件
 */
fun testAll() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    val anyResult = list.any { it.length <= 5 }
    val allResult = list.all { it.length <= 5 }
    println("anyResult is " + anyResult + ", allResult is " + allResult)
}


fun testJavaApi() {
//    new Thread(new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("Thread is running");
//        }
//    }).start();

//    Thread(object : Runnable {
//        override fun run() {
//            println("Thread is running")
//        }
//    }).start()

    //有且仅有一个Java 单抽象方法接口参数
//    Thread({
//        println("Thread is running")
//    }).start()
    Thread {
        println("Thread is running")
    }.start()

//    button.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//        }
//    });
//    button.setOnClickListener {};
}

