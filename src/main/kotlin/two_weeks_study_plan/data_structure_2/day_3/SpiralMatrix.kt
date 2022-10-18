package two_weeks_study_plan.data_structure_2.day_3

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/spiral-matrix-ii/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(SpiralMatrix().generateMatrix(3).joinToString())
}

class SpiralMatrix {
    fun generateMatrix(n: Int): Array<IntArray> {
        val array = Array(n) { IntArray(n) { -1 } }

        var starRow = 0
        var endRow = n - 1
        var startCol = 0
        var endCol = n - 1

        var count = 1

        while (starRow <= endRow && startCol <= endCol) {
            for (i in startCol..endCol) {
                array[starRow][i] = count
                count++
            }

            starRow++

            for (i in starRow..endRow) {
                array[i][endCol] = count
                count++
            }

            endCol--

            for (i in endCol downTo startCol) {
                if (starRow == endRow) break
                array[endRow][i] = count
                count++
            }

            endRow--

            for (i in endRow downTo starRow) {
                if (startCol == endCol) break
                array[i][startCol] = count
                count++
            }

            startCol++

        }
        return array

    }
}