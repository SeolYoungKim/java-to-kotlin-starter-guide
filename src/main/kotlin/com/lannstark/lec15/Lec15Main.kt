package com.lannstark.lec15

fun main() {
    // 배열
    val array = arrayOf(1, 2, 3, 4, 5)

    // 1. 인덱스 가져오기
    for (i in array.indices) {
        println("$i : ${array[i]}")
    }

    println("-----")

    // 2. 인덱스와 value 한번에 가져오기
    for ((index, value) in array.withIndex()) {
        println("$index : $value")
    }

    println("-----")

    // 3. forEach
    for (i in array) {
        println(i)
    }

    array.plus(6)  // 배열에 요소 추가 (내부적으로 복사해서 사용)

    println("-----")
    /* -------------------------------------------- */

    // List
    val mutableList = mutableListOf(1, 2, 3, 4, 5)  // 가변 리스트
    mutableList.add(6)

    val list = listOf(1, 2, 3, 4, 5)  // 불변 리스트

    val emptyList = emptyList<Int>()  // 비어있는 리스트는 타입 명시 필요
    printNumbers(emptyList())  // 타입 추론이 가능한 경우는 <> 생략 가능

    // 하나를 가져오기
    println(list[0])
    println("-----")

    // for each
    for (i in list) {
        println(i)
    }

    println("-----")

    // 전통적인 for문
    for ((idx, value) in list.withIndex()) {
        println("$idx : $value")
    }

    /* -------------------------------------------- */
    // Set
    val mutableSet = mutableSetOf(1, 2, 3, 4, 5, 5, 5, 5, 5)  // 중복을 허용하지 않음

    val set = setOf(1, 2, 3, 4, 5, 5, 5, 5, 5)  // 중복을 허용하지 않음
    for (i in set) {
        println(i)
    }

    for ((idx, value) in set.withIndex()) {
        println("$idx : $value")
    }

    println("-----")
    /* -------------------------------------------- */
    // Map
    val mutableMap = mutableMapOf<Int, String>()
    mutableMap[1] = "one"
    mutableMap[2] = "two"
    mutableMap[3] = "three"

    val map = mapOf(1 to "one", 2 to "two", 3 to "three")

    println("-----")
    for (key in map.keys) {
        println("$key : ${map[key]}")
    }

    println("-----")
    for ((key, value) in map) {
        println("$key : $value")
    }

    println("-----")
    for (entry in map) {
        println("${entry.key} : ${entry.value}")
    }

    println("-----")
    for (entry in map.entries) {
        println("${entry.key} : ${entry.value}")
    }

    println("-----")

}

private fun printNumbers(numbers: List<Int>) {
    for (number in numbers) {
        println(number)
    }
}