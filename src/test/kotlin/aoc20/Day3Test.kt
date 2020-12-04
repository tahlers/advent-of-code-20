package aoc20

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.vavr.kotlin.*

class Day3Test : FunSpec({

    val sample = """
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
        """.trimIndent()

    test("calcTreeHits for sample input"){
        val result = Day3.calcTreeHits(sample, Step(3, 1))
        result shouldBe 7
    }

    test("calcTreeHits for input"){
        val input = this.javaClass.getResource("/day_03_1.txt").readText().trim()
        val result = Day3.calcTreeHits(input, Step(3, 1))
        result shouldBe 230
    }

    test("calcTreeHits for sample input for multiple steps"){
        val steps = listOf(
            Step(1, 1),
            Step(3, 1),
            Step(5, 1),
            Step(7, 1),
            Step(1, 2),
        ).toVavrList()
        val result = Day3.calcTreeHits(sample, steps)
        result shouldBe 336
    }

    test("calcTreeHits for input with multiple steps"){
        val input = this.javaClass.getResource("/day_03_1.txt").readText().trim()
        val steps = listOf(
            Step(1, 1),
            Step(3, 1),
            Step(5, 1),
            Step(7, 1),
            Step(1, 2),
        ).toVavrList()
        val result = Day3.calcTreeHits(input, steps)
        result shouldBe 9533698720L
    }})