package com.lannstark.lec20

import com.lannstark.lec19.Person

fun printPerson(person: Person?) {
    if (person != null) {
        println(person.name)
        println(person.age)
    }
}

fun printPersonWithLet(person: Person?) {
    person?.let {  // scope function의 한 종류
        println(it.name)
        println(it.age)
    }
}

data class PersonDto(
    val name: String,
    val age: Int,
)

fun main() {
    with(person, {
        println(name)
        println(this.age)
    })

    with(person) {
        println(name)
        println(this.age)
    }

    val personDto1 = PersonDto(person.name, person.age)
    val personDto2 = with(person) {
        PersonDto(name, age)
    }



    val strings = listOf("apple", "hello world", "car")
    strings.map { it.length }
        .filter { it > 3 }
        .let { lengths -> println(lengths) }

    val str: String? = "nullable string"
    val length = str?.let {
        println(it.uppercase())
        it.length
    }

    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first()
        .let { firstItem ->
            if (firstItem.length >= 5) {
                firstItem
            } else {
                "!$firstItem"
            }
        }.uppercase()
    println(modifiedFirstItem)
}

fun createPerson(
    name: String,
    age: Int,
    hobby: String,
): Person {
    return Person(
        name = name,
        age = age,
    ).apply {
//        this.hobby = hobby
    }
}

val person = Person("Kim", 120)

val value1 = person.let {
    it.age  // it 생략 불가
}

val value2 = person.run {
    this.age  // this 생략 가능
}

val value3 = person.also {
    it.age
}

val value4 = person.apply {
    this.age
}
