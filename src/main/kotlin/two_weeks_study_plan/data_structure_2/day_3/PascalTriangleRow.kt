package two_weeks_study_plan.data_structure_2.day_3

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/pascals-triangle-ii/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(PascalTriangleRow().getRow2(30).joinToString())
}

class PascalTriangleRow {
    fun getRow(rowIndex: Int): List<Int> {
        val list = mutableListOf<List<Int>>()
        for (i in 0 until rowIndex + 1) {
            val row = mutableListOf<Int>()

            for (j in 0..i) {
                if (j == i || j == 0) {
                    row.add(j, 1)
                } else {
                    row.add(j, list[i - 1][j - 1] + list[i - 1][j])
                }
            }
            list.add(row)
        }
        return list.last()
    }

    // nth row in pascal triangle is NCr = (NCr - 1 * (N - r + 1)) / r where 1 ≤ r ≤ N
    fun getRow2(rowIndex: Int): List<Long> {
        val list = mutableListOf<Long>()
        var prev = 1L
        list.add(prev)
        for (i in 1..rowIndex) {
            val curr = (prev * (rowIndex - i + 1)) / i
            list.add(curr)
            prev = curr
        }
        return list
    }
}