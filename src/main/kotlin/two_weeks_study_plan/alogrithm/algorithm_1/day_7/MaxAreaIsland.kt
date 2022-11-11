package two_weeks_study_plan.alogrithm.algorithm_1.day_7


/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/max-area-of-island/?envType=study-plan&id=algorithm-i
 */

fun main() {
}

class MaxAreaIsland {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0

        fun getAreaAndHideTheIsland(i: Int, j: Int): Int {
            var result = 0
            if (i in grid.indices && j in grid.first().indices && grid[i][j] == 1) {
                grid[i][j] = 0
                result++
                result += getAreaAndHideTheIsland(i - 1, j)
                result += getAreaAndHideTheIsland(i + 1, j)
                result += getAreaAndHideTheIsland(i, j - 1)
                result += getAreaAndHideTheIsland(i, j + 1)
            }
            return result
        }

        for (i in grid.indices) {
            for (j in grid.first().indices) {
                if (grid[i][j] == 1) {
                    maxArea = maxOf(maxArea, getAreaAndHideTheIsland(i, j))
                }
            }
        }
        return maxArea
    }
}