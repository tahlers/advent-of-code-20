package aoc20

import io.vavr.collection.HashSet
import io.vavr.collection.List
import io.vavr.collection.Set

data class Step(val right: Int, val down: Int)

data class Tree(val x: Int, val y: Int)

object Day3 {

    fun parseField(field: String): Set<Tree> {
        return HashSet.ofAll(
            field.lines().mapIndexed { rowCount, line ->
                line.mapIndexed { colCount, c ->
                    if (c == '#') Tree(colCount, rowCount) else null
                }.filterNotNull()
            }.flatten()
        )
    }

    fun calcTreeHits(field: String, step: Step): Long {
        val treeField = parseField(field)
        val maxY = field.lines().size
        val maxX = field.lines()[0].length

        return walkField(0, 0, step, treeField, maxX, maxY)
    }

    fun calcTreeHits(field: String, steps: List<Step>): Long{
        val treeField = parseField(field)
        val maxY = field.lines().size
        val maxX = field.lines()[0].length

        return steps.map { walkField(0, 0, it, treeField, maxX, maxY) }
            .product()
            .toLong()
    }
    fun walkField(posX: Int, posY: Int, step: Step, field: Set<Tree>, maxX: Int, maxY: Int): Long {
        val isTree = field.contains(Tree(posX, posY))
        val treeInc = if (isTree) 1 else 0
        return if (posY >= maxY) {
            treeInc.toLong()
        } else {
            val newPosX = (posX + step.right) % maxX
            val newPosY = posY + step.down
            treeInc + walkField(newPosX, newPosY, step, field, maxX, maxY)
        }
    }

}