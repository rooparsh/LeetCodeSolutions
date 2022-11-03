package two_weeks_study_plan.data_structure_2.day_19

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    println(
        MinimumNumberOfVertices().findSmallestSetOfVertices(
            6,
            listOf(
                listOf(0, 1),
                listOf(0, 2),
                listOf(2, 5),
                listOf(3, 4),
                listOf(4, 2),
            )
        ).joinToString()
    )
}

class MinimumNumberOfVertices {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>, result: IntArray = IntArray(n)): List<Int> = edges
        .map { result[it[1]]++ }
        .run {
            result
                .withIndex()
                .filter { it.value == 0 }
                .map { it.index }
        }
}