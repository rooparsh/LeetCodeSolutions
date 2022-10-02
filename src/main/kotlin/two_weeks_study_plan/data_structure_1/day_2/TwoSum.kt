package two_weeks_study_plan.data_structure_1.day_2

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/two-sum/?envType=study-plan&id=data-structure-i
 */

fun main() {

    val array = arrayOf(3, 3).toIntArray()

    print(TwoSum().twoSum(array, 6).joinToString())

}

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, int ->
            map[int]?.let { return intArrayOf(it, index) }
            map[target - int] = index
        }
        return intArrayOf()

    }
}