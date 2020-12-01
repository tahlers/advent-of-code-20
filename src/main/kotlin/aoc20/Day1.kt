package aoc20

import io.vavr.collection.Seq
import io.vavr.kotlin.toVavrList

object Day1 {

    fun calculateExpanse(input: Seq<String>, parts: Int = 2): Int {
        val numbers = input.mapNotNull { it.toIntOrNull() }.toVavrList()
        val result = numbers
            .combinations(parts)
            .find {it.sum().toInt() == 2020}
            .map { it.foldLeft(1, { a, b -> a * b}) }
            .getOrElse(0)
        return result;
    }

}