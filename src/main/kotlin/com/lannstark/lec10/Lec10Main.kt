package com.lannstark.lec10

open class Base(
    open val number: Int = 100
) {
    init {
        println("Base init")
        println("number: $number")
    }
}

class Derived(
    override val number: Int
) : Base(number) {
    init {
        println("Derived init")
    }
}

fun main() {
    Derived(200)
}


class Test() : Base() {
    init {
        println("Test init")
    }
}