package leetcode_75.daily.mapSet

/**
 * Difficulty : Easy
 * Problem Statement :https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(findDifference(intArrayOf(1, 2, 3), intArrayOf(2, 4, 6)).joinToString())
}

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val set1 = nums1.toHashSet()
    val set2 = nums2.toHashSet()
    val list1 = arrayListOf<Int>()
    set1.forEach {
        if (set2.contains(it)) {
            set2.remove(it)
        } else {
            list1.add(it)
        }
    }

    return listOf(list1, set2.toList())
}