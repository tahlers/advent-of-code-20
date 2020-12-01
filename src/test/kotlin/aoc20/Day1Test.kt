package aoc20

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.vavr.kotlin.*

class Day1Test : FunSpec({

    test("calculateExpanse should report 514579 for sample input"){
        val sample = list("1721", "979", "366", "299", "675", "1456")
        val result = Day1.calculateExpanse(sample)
        result shouldBe 514579
    }

    test("calculate solution one") {
        val lines = this.javaClass.getResource("/day_01_1.txt").readText().lines()
        val result = Day1.calculateExpanse(lines.toVavrList())
        result shouldBe 138379
    }

    test("calculateExpanse part 2 should report 241861950 for sample input"){
        val sample = list("1721", "979", "366", "299", "675", "1456")
        val result = Day1.calculateExpanse(sample, 3)
        result shouldBe 241861950
    }

    test("calculate solution two") {
        val lines = this.javaClass.getResource("/day_01_1.txt").readText().lines()
        val result = Day1.calculateExpanse(lines.toVavrList(), 3)
        result shouldBe 85491920
    }
})