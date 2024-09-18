package com.lannstark.lec07

import java.io.BufferedReader
import java.io.FileReader

fun parseIntOrThrow(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("${str}는 숫자가 아닙니다.")
    }
}

fun parseIntOrReturnNull(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

fun main() {
    FilePrinter().readFile()
    FilePrinter().readFileAutoClose()
}

class FilePrinter {
    fun readFile() {
        val bufferedReader = BufferedReader(FileReader("a.txt"))
        val line = bufferedReader.readLine()
        println(line)
        bufferedReader.close()
    }

    fun readFileAutoClose() {
        BufferedReader(FileReader("a.txt")).use { reader ->
            val line = reader.readLine()
            println(line)
        }
    }
}