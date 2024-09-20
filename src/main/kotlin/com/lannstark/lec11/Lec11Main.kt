package com.lannstark.lec11

fun main() {
    println(isDirectoryPath("/usr/local/bin"))
    println(isDirectoryPath("usr/local/bin"))
}

class Car(
    internal val name: String,
    private var owner: String,
    _price: Int
) {
    var price = _price
    private set
}