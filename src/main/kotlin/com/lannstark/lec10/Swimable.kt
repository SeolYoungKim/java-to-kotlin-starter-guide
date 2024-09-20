package com.lannstark.lec10

interface Swimable {
    val swimAbility: Int
        get() = 10

    fun act() {
        println("SwimAbility: $swimAbility")
        println("Swimable act")
    }

    fun swim()
}