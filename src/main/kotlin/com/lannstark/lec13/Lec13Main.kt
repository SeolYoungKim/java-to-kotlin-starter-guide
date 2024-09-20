package com.lannstark.lec13

class House(
    val address: String,
    val livingRoom: LivingRoom = LivingRoom(20.0)
) {
    class LivingRoom(val area: Double)
}

fun main() {
    val house = House("Seoul", House.LivingRoom(30.0))
    println(house.address)
    println(house.livingRoom.area)
}