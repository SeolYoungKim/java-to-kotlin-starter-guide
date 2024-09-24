package com.lannstark.lec19

import com.lannstark.lec17.Fruit as Lec17Fruit
import com.lannstark.lec18.Fruit

private fun filterFruitsLec17(
    fruits: List<Lec17Fruit>, filter: (Lec17Fruit) -> Boolean
): List<Lec17Fruit> {
    return fruits.filter(filter)
}

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits.filter(filter)
}

typealias FruitFilter = (Fruit) -> Boolean

private fun filterFruitsWithAlias(
    fruits: List<Fruit>, filter: FruitFilter
): List<Fruit> {
    return fruits.filter(filter)
}

data class UltraSuperGuardianTribe(val name: String)

typealias USGTMap = Map<String, UltraSuperGuardianTribe>

class Person(
    val name: String,
    val age: Int
) {
    operator fun component1(): String = name
    operator fun component2(): Int = age
}

fun main() {
    val numbers = listOf(1, 2, 3)
    numbers.map { number -> number + 1 }
        .forEach { number -> println(number) }

    run {
        numbers.map { number -> number + 1 }
            .forEach { number ->
                if (number == 2) {
                    return@run
                }
                println(number)
            }
    }

    numbers.map { number -> number + 1 }
        .forEach { number ->
            if (number == 2) {
                return@forEach
            }
            println(number)
        }

    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@loop
            }
            println("$i $j")
        }
    }
}

fun getNumberOrNull(number: Int): Int? {
    return if (number <= 0) {
        null
    } else {
        number
    }
}

// takeIf : 주어진 조건을 만족하면 값을 반환하고, 그렇지 않으면 null을 반환한다
fun getNumberOrNullWithTakeIf(number: Int): Int? {
    return number.takeIf { num -> num > 0 }
}

// takeUnless : 주어진 조건을 만족하지 않으면 값을 반환하고, 그렇지 않으면 null을 반환한다
fun getNumberOrNullWithTakeUnless(number: Int): Int? {
    return number.takeUnless { num -> num <= 0 }
}

