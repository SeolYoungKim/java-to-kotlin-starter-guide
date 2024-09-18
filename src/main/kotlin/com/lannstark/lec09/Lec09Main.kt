package com.lannstark.lec09

class Person(
    name: String = "",
    var age: Int = 1
) {
    var name = name
        set(value) {
            field = value.uppercase()
        }

    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 0보다 커야 합니다. 입력=${age}")
        }
        println("초기화 블록")
    }

//    fun isAdult(): Boolean {
//        return age >= 20
//    }

    val isAdult: Boolean
        get() {
            return age >= 20
        }

    val upperName: String
        get() = name.uppercase()
}

class Student

fun main() {
    val student = Student()
    Person()
    println("-----")

    val baby = Person("Baby")
    println(baby.name)
    println(baby.isAdult)

    val person = Person("Kim", 30)
    println(person.name)
    println(person.age)
    person.age = 31
    println(person.age)

    println("-----")

    val javaPerson = JavaPerson("Kim", 30)
    println(javaPerson.name)
    println(javaPerson.age)
    javaPerson.age = 31
    println(javaPerson.age)
}