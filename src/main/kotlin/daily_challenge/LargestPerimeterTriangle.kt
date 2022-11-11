package daily_challenge

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/largest-perimeter-triangle/
 */

fun main() {
    println(LargestPerimeterTriangle().largestPerimeter(intArrayOf(1, 2, 1)))
}

class LargestPerimeterTriangle {
    fun largestPerimeter(nums: IntArray): Int {
        val sortedArray = nums.sortedArray()

        for (i in nums.lastIndex downTo 2) {
            val longestSide = sortedArray[i]
            val perimeter = longestSide + sortedArray[i - 1] + sortedArray[i - 2]
            val sumOfRemainSides = sortedArray[i - 1] + sortedArray[i - 2]
            if (sumOfRemainSides > longestSide) return perimeter
        }
        return 0
    }
}