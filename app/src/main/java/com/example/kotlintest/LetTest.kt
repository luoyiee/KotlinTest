package com.example.kotlintest

class LetTest {

//    obj.let { obj2 ->
//        // 编写具体的业务逻辑
//    }

    fun doStudyNull(study: Study?) {
        study?.watchTv()
        study?.readBook()
    }

    /**
     * ?就表示可为空
     * ?.为空不做操作
     * ?:三元运算
     * 非空断言工具!!
     * let可以全局判空,if不可以
     */
    fun doStudyLet(study: Study?) {
        study?.let { stu ->
            stu.watchTv()
            stu.readBook()
        }
    }

    fun doStudyPlus(study: Study?) {
        study?.let {
            it.watchTv()
            it.readBook()
        }
    }

//    var study: Study? = null
//    fun doStudy() {
//        study.watchTv()
//        study.readBook()
//    }
}