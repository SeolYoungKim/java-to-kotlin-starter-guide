package com.lannstark.lec01

fun main() {
    var number1 = 10L
    number1 = 5L

    val number2 = 10L
//     number2 = 5L // Error

    val number3: Long = 10  // 타입을 작성할 수 있다

    // 값을 넣지 않으면 타입을 추론할 수 없다
//    val number4

    var number4: Long
//    println(number4)  // 초기화 하지 않으면 에러

    // 코틀린의 null 처리
    var number5: Long? = null
//    var number6: Long = null  // null이 들어갈 수 없음

    var person = Person("kim")
}