package com.lannstark.lec03

fun main() {
    val number1 = 3     // Int
    val number2 = 3L    // Long
    val number3 = 3.0f  // Float
    val number4 = 3.0   // Double

    val numberInteger = 4
    val numberLong: Long = numberInteger.toLong()

    val nullableNumber: Int? = null
    val numberLong2 = nullableNumber?.toLong() ?: 0L

    printAgeIfPerson(null)
//    fail("Error occurred")

    val person = Person("공부하는 개발자", 10)
    val log = "사람의 이름은 ${person.name}이고, 나이는 ${person.age}입니다."
    println(log)

    val name = person.name
    println("person: $name")

    val nonTrimIndent = """
        |Hello
        |World
    """
    println("[nonTrimIndent]\n${nonTrimIndent}")
    println()

    val trimIndent = """
        |Hello
        |World
    """.trimIndent()
    println("[trimIndent]\n${trimIndent}")
    println()

    val trimMargin = """
        >Hello
        >World
    """.trimMargin(">")
    println("[trimMargin]\n${trimMargin}")

    val str = "Hello"
    println("첫번째 인덱스 문자 = ${str.first()}")
    println("1번 인덱스 문자 = ${str[1]}")
    println("마지막 인덱스 문자 = ${str.last()}")
}

fun printAgeIfPerson(obj: Any?) {
    val person = obj as? Person  // null일 경우 전체가 null
    println(person?.age)
}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}