package aoc20

import io.vavr.collection.Seq
import io.vavr.kotlin.toVavrList

data class PasswordEntry(val min: Int, val max: Int, val char: Char, val pw: String)

object Day2 {

    fun calculateValidPasswords(input: String): Int {
        val entries = parseInput(input)
        val matched = entries
            .filter { entry ->
                val count = entry.pw.count { it == entry.char }
                entry.min <= count && count <= entry.max
            }
        return matched.size
    }

    fun calculateValidPasswords2(input: String): Int {
        val entries = parseInput(input)
        val matched = entries
            .filter { entry ->
                val cand1 = entry.pw[entry.min - 1] == entry.char
                val cand2 = entry.pw[entry.max - 1] == entry.char
                cand1 xor cand2
            }
        return matched.size
    }


    private fun parseInput(input: String): List<PasswordEntry> {
        val lines = input.lines()
        val entries = lines.map { line ->
            val (pattern, pw) = line.split(": ")
            val char = pattern.takeLast(1)
            val (min, max) = pattern.dropLast(2).split("-")
            PasswordEntry(min.toInt(), max.toInt(), char[0], pw)
        }
        return entries
    }

}