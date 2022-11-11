package daily_challenge

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/set-mismatch/
 */

fun main() {
    print(SetMismatch().findErrorNums(intArrayOf(3, 2, 3, 4, 6, 5)).joinToString())
}

class SetMismatch {
    fun findErrorNums(nums: IntArray): IntArray {
        val actualSum = nums.sum()
        val correctSum = List(nums.size) { it + 1 }.sum()

        val diff = correctSum - actualSum

        val duplicateNumber = nums.toList()
            .groupingBy { it }
            .eachCount()
            .filter { it.value > 1 }
            .toList()
            .first()
            .first

        return intArrayOf(duplicateNumber, duplicateNumber + diff)
    }
}