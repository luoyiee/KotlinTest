package com.example.kotlintest.model

/**
 * sealed class密封类--可继承--不需要else
 */
//interface Result {
sealed class Result {
    class Success(val msg: String) : Result()
    class Failure(val error: Exception) : Result()
//    class UnKnown(val msg: String) : Result()

    //必须写else--多余
    fun getResultMsg(result: Result) = when (result) {
//        is Success -> result.msg
//        is Failure -> result.error.message
//        else -> throw IllegalArgumentException()
        is Success -> result.msg
        is Failure -> "Error is ${result.error.message}"
//        is UnKnown -> result.msg
    }

}