package two_weeks_study_plan.alogrithm.algorithm_1.day_12

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/triangle/?envType=study-plan&id=algorithm-i
 */

fun main() {
    print(
        Triangle().minimumTotal(
            mutableListOf(
                listOf(2),
                listOf(3, 4),
                listOf(6, 5, 7),
                listOf(4, 1, 8, 3)
            )
        )
    )
}

class Triangle {

    fun minimumTotal(triangle: List<List<Int>>): Int {
        val check = ArrayList<Int>(triangle[triangle.size-1])

        for ( i in triangle.size - 2 downTo 0) {
            for(j in triangle[i].indices) {
                check[j] = triangle[i][j] + Math.min(check[j], check[j+1])
            }
        }
        return check[0]
    }
}