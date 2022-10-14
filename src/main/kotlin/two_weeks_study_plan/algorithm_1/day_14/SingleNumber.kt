package two_weeks_study_plan.algorithm_1.day_14

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/single-number/?envType=study-plan&id=algorithm-i
 */


fun main() {
    println(SingleNumber().singleNumber2(intArrayOf(2, 2, 1)))
}

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        val map = nums.toList().groupingBy { it }.eachCount()
        map.forEach { (t, u) -> if (u == 1) return t }
        return 0
    }

    fun singleNumber2(nums: IntArray): Int {
        var bits = 0
        nums.forEach {
            bits = bits xor it
        }
        return bits
    }
}