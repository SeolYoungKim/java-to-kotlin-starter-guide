package com.lannstark.lec08

fun max(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun maxWithEqualSign(a: Int, b: Int) = if (a > b) a else b

fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

fun printNameAndGender(name: String, gender: String) {
    println("Name: $name")
    println("Gender: $gender")
}

fun main() {
    printAll("a", "b", "c")

    val array = arrayOf("a", "b", "c")
    printAll(*array)  // 배열을 바로 넣는 대신 spread 연산자를 사용해야 한다
}

fun printAll(vararg strings: String) {
    for (string in strings) {
        println(string)
    }
}
