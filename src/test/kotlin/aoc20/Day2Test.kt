package aoc20

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class Day2Test : FunSpec({

    test("calculateValidPasswords for sample input"){
        val sample = """
            1-3 a: abcde
            1-3 b: cdefg
            2-9 c: ccccccccc
        """.trimIndent()

        val result = Day2.calculateValidPasswords(sample)
        result shouldBe 2
    }

    test("calculateValidPasswords for input"){
        val input = this.javaClass.getResource("/day_02_1.txt").readText().trim()
        val result = Day2.calculateValidPasswords(input)
        result shouldBe 447
    }

    test("calculateValidPasswords2 for sample input"){
        val sample = """
            1-3 a: abcde
            1-3 b: cdefg
            2-9 c: ccccccccc
        """.trimIndent()
        val result = Day2.calculateValidPasswords2(sample)
        result shouldBe 1
    }

    test("calculateValidPasswords2 for input"){
        val input = this.javaClass.getResource("/day_02_1.txt").readText().trim()
        val result = Day2.calculateValidPasswords2(input)
        result shouldBe 249
    }

})