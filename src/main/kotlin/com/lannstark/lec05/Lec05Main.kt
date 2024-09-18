package com.lannstark.lec05

fun validateScoreIsNotNegative(score: Int): Unit {
    if (score < 0) {
        throw IllegalArgumentException("${score}는 음수일 수 없습니다.")
    }
}

fun validateScore(score: Int): Unit {
    if (score !in 0..100) {
        throw IllegalArgumentException("${score}는 0에서 100 사이여야 합니다.")
    }
}

fun getPassOrFailStatement(score: Int): String {
    if (score >= 80) {
        return "P"
    } else {
        return "F"
    }
}

fun getPassOrFailExpression(score: Int): String {
    return if (score >= 80) {
        "P"
    } else {
        "F"
    }
}

fun getGrade(score: Int): String {
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else if (score >= 60) {
        "D"
    } else {
        "F"
    }
}

fun getGradeWithWhen(score: Int): String {
    return when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
    }
}

fun getGradeWithWhen2(score: Int): String {
    return when(score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        6 -> "D"
        else -> "F"
    }
}

fun startsWithA(input: Any): Boolean {
    return when (input) {
        is String -> input.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int): String {
    return when(number) {
        1, 0, -1 -> "어디서 많이 본 숫자"
        else -> "1, 0, -1 이외의 숫자"
    }
}

fun judgeNumber2(number: Int): String {
    return when {
        number == 0 -> "0"
        number % 2 == 0 -> "짝수"
        else -> "홀수"
    }
}