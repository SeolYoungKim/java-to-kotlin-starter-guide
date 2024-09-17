package com.lannstark.lec04

fun main() {
    val money1 = JavaMoney(2000)
    val money2 = money1
    val money3 = JavaMoney(2000)
    val money4 = JavaMoney(1000)

    if (money1 > money4) {
        println("money1이 더 크다")
    } else {
        println("money4가 더 크다")
    }

    if (money1 == money3) {
        println("money1과 money3의 값은 같다")
    } else {
        println("money1과 money3의 값은 다르다")
    }

    if (money1 === money2) {
        println("money1과 money2은 같은 객체다")
    } else {
        println("money1과 money2은 다른 객체다")
    }

    val appendedMoney = Money(1000) + Money(2000)
    println("appendedMoney: $appendedMoney")
}