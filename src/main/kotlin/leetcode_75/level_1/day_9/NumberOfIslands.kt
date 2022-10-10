package leetcode_75.level_1.day_9

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/number-of-islands/?envType=study-plan&id=level-1
 */
fun main() {

}

class NumberOfIslands {

    fun numIslands(grid: Array<CharArray>): Int {
        var num = 0

        grid.forEachIndexed { i, arr ->
            arr.forEachIndexed { j, ch ->
                if (grid[i][j] == '1') {
                    num += dfs(grid, i, j)
                }
            }
        }

        return num
    }

    fun dfs(grid: Array<CharArray>, i: Int, j: Int): Int {

        if (i < 0 || i >= grid.size || j < 0 || j >= grid[i].size || grid[i][j] == '0') {
            return 0
        }

        grid[i][j] = '0'
        dfs(grid, i + 1, j)
        dfs(grid, i - 1, j)
        dfs(grid, i, j + 1)
        dfs(grid, i, j - 1)

        return 1
    }
}