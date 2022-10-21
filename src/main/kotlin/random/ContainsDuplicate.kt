package random

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/contains-duplicate-ii/
 */

fun main() {
    print(ContainsDuplicate().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
}


class ContainsDuplicate {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { i, num ->
            if (map.containsKey(num) && i - map[num]!! <= k) return true
            map[num] = i
        }

        return false
    }
}