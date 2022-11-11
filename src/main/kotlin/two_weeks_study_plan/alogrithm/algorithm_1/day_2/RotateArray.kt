package two_weeks_study_plan.alogrithm.algorithm_1.day_2


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/rotate-array/?envType=study-plan&id=algorithm-i
 */

fun main() {

    val array = arrayOf(1, 2, 3, 4, 5, 6, 7).toIntArray()
    RotateArray().rotate(array, 3)
    print(array.joinToString())

}


class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (nums.isEmpty()) return
        val rotate = k % nums.size

        val copy = nums.copyOf()
        for (i in nums.indices) {
            nums[(rotate + i) % nums.size] = copy[i]
        }
    }
}