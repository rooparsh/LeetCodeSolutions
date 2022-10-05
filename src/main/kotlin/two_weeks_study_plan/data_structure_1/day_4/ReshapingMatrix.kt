package two_weeks_study_plan.data_structure_1.day_4


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/reshape-the-matrix/?envType=study-plan&id=data-structure-i
 */
fun main() {

    val array = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))

    println(ReshapingMatrix().matrixReshape(array, 1, 4).joinToString())

}

class ReshapingMatrix {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        if (r * c != mat.size * mat[0].size) {
            return mat
        }


        val list = mutableListOf<Int>()
        for (row in mat) {
            for (item in row) {
                list.add(item)
            }
        }

        var currentIndex = 0

        val newArray = Array(r) { IntArray(c) }


        for (i in newArray.indices) {
            val row = newArray[i]

            for (j in row.indices) {
                newArray[i][j] = list[currentIndex]
                currentIndex++
            }
        }

        return newArray
    }
}