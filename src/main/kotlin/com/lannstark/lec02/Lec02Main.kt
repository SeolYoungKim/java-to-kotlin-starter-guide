package com.lannstark.lec02

fun main() {
    val str: String? = null
//    str.length // 불가능
    val length = str?.length // 가능
    println("length: $length")

    val length2 = str?.length ?: 0
    println("length2: $length2")

    val person = Person("공부하는 개발자")
    startsWithA(person.name)
}

fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}


fun startsWithA1(str: String?): Boolean {
    if (str == null) {
        throw IllegalArgumentException("str must not be null")
    }

    return str.startsWith("A")
}

fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
//    str.startsWith("A")  // str은 nullable 하기 때문에 이렇게 사용하면 컴파일 에러가 남
    if (str == null) {
        return false
    }

    return str.startsWith("A")
}

fun startsWithA4(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}

fun startsWithA5(str: String?): Boolean {
    return str?.startsWith("A") ?: throw IllegalArgumentException("str must not be null")
}

fun startsWithA6(str: String?): Boolean {
    str ?: return false
    return str.startsWith("A")
}

fun startsWithA7(str: String?): Boolean {
    return str!!.startsWith("A")
}

