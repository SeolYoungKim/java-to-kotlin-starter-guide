package com.lannstark.lec12

import com.lannstark.lec12.Movable

interface Log {
    fun log()
}

class Person private constructor(
    var name: String,
    var age: Int
) {
    companion object : Log {  // static 대신 사용
        private const val MIN_AGE = 1

        @JvmStatic
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("Person class의 Companion object Factory 입니다.")
        }
    }
}

object Singleton : Log {
    var a = 10
    override fun log() {
        println("Singleton object 입니다.")
    }
}

fun main() {
    val anonymousClass = object : Movable {
        override fun move() {
            println("move")
        }

        override fun fly() {
            println("fly")
        }
    }
    moveSomething(anonymousClass)
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}
