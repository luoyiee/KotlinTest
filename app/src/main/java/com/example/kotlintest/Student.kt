package com.example.kotlintest

class Student(val sno: String, val grade: Int, name: String, age: Int) :
    Person(name, age) ,Study{


    /**
     * 次构造函数是通过constructor关键字来定义的
     */
    constructor(name: String, age: Int) : this("", 0, name, age) {
    }
    constructor() : this("", 0) {
    }

    init {
        println("sno is " + sno)
        println("grade is " + grade)
    }
    override fun readBook() {
        println(name + " is readBook.")
    }

    override fun watchTv() {
        println(name + " is watchTv.")
    }
}