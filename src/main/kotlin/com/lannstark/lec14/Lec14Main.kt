package com.lannstark.lec14

data class PersonDto(
    val name: String,
    val age: Int,
)

enum class Country(val code: String) {
    KOREA("KO"), USA("US"), CANADA("CA")
}

private fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> println("한국")
        Country.USA -> println("미국")
        Country.CANADA -> println("캐나다")
    }
}

sealed class HyundaiCar(
    val name: String,
    val price: Int,
)

class Avante : HyundaiCar("아반떼", 2000)
class Sonata : HyundaiCar("소나타", 3000)
class Grandeur : HyundaiCar("그랜저", 4000)
class Venue : HyundaiCar("베뉴", 1500)

//'when' expression on sealed classes is recommended to be exhaustive, add 'is Venue' branch or 'else' branch instead
fun handleCar(car: HyundaiCar) {
    when (car) {
        is Avante -> println("아반떼")
        is Sonata -> println("소나타")
        is Grandeur -> println("그랜저")
        is Venue -> println("베뉴")
    }
}

fun main() {
    val person = PersonDto("person!", 27)
    println(person)
    println(person.name)
    println(person.age)
    println(person.hashCode())

    val person2 = person.copy(name = "person!")
    println("equals: ${person == person2}")

    println("-----------------")

    println(Country.KOREA)
    println(Country.USA)

    println(Country.KOREA.code)
    println(Country.USA.code)

    println("-----------------")

}
