package com.example.kotlintest.ui.part6_Broadcast

/**
 * 内联函数
 * inline关键字
 * noinline取消内联
 * (String, Int) -> Unit
 * 可使用return
 * 高阶函数实现原理。你会发现，原来我们一直使用的Lambda表达式在底层被转换成了匿名类的实现方式。这就表明，我们每调用一次Lambda表达式，都会创建一个新的匿名类实例，当然也会造成额外的内存和性能开销。
 */

inline fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}

fun main() {
    val num1 = 100
    val num2 = 80
    val result = num1AndNum2(num1, num2) { n1, n2 ->
        n1 + n2
    }
}

//public static int num1AndNum2(int num1, int num2, Function operation) {
//    int result = (int) operation.invoke(num1, num2);
//    return result;
//}
//public static void main() {
//    int num1 = 100;
//    int num2 = 80;
//    int result = num1AndNum2(num1, num2, new Function() {
//        @Override
//        public Integer invoke(Integer n1, Integer n2) {
//            return n1 + n2;
//        }
//    });
//}
