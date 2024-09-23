package com.lannstark.lec16

fun main() {
    val str = "ABC"
    val lastChar = str.lastChar()
    println("lastChar = $lastChar")

    val lowercase = str.lowercase()
    println("lowercase = $lowercase")

    val person = Person("kim", "seol young", 34)
    person.nextYearAge()
}

// String을 확장하는 함수
fun String.lastChar(): Char {
    return this[this.length - 1]
}

fun String.lowercase(): String {
    println("내가 정의한 확장 함수")
    return this.uppercase()
}

fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}

fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.infixAdd(other: Int): Int {
    return this + other
}

inline fun Int.inlineAdd(other: Int): Int {
    return this + other
}

fun createPerson(firstName: String, lastName: String): Person {
    fun validateName(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("$fieldName must not be empty")
        }
    }

    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return Person(firstName, lastName, 1)
}