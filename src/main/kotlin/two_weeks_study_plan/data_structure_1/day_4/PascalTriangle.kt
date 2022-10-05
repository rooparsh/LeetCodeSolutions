package two_weeks_study_plan.data_structure_1.day_4

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/pascals-triangle/?envType=study-plan&id=data-structure-i
 */
fun main() {

    println(PascalTriangle().generate(5).joinToString())

}

class PascalTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val list = mutableListOf<List<Int>>()

        for (i in 0 until numRows) {
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
        return list
    }
}