package random

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/increasing-triplet-subsequence/
 */
fun main() {
    print(IncreasingTripletSubsequence().increasingTriplet(intArrayOf(20, 100, 10, 12, 5, 13)))
}

class IncreasingTripletSubsequence {
    fun increasingTriplet(nums: IntArray): Boolean {
        var firstSmallest = Int.MAX_VALUE
        var secondSmallest = Int.MAX_VALUE

        nums.forEach { num ->
            if (num <= firstSmallest) firstSmallest = num
            else if (num <= secondSmallest) secondSmallest = num
            else return true
        }

        return false
    }
}