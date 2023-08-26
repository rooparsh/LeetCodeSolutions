package leetcode_75.daily.two_pointer

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
 */
fun main() {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}

fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1

    var maxArea = 0

    while (left <= right) {
        val breadth = if (height[left] < height[right]) {
            height[left]
        } else {
            height[right]
        }

        val length = right - left

        val area = breadth * length

        if (area >= maxArea) {
            maxArea = area
        }

        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return maxArea
}