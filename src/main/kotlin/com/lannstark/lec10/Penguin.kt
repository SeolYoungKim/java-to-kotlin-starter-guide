package com.lannstark.lec10

class Penguin(
    species: String,
    private val wingCount: Int = 2,
) : Animal(species, 2), Swimable, Flyable {

    override fun move() {
        println("Penguin is moving")
    }

    override val legCount: Int
        get() = super.legCount + wingCount

    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }

    override fun fly() {
        println("Penguin is flying")
    }

    override fun swim() {
        println("Penguin is swimming")
    }

    override val swimAbility: Int
        get() = 3
}