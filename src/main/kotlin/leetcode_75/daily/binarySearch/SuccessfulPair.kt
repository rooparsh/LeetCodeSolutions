package leetcode_75.daily.binarySearch

import java.util.Arrays

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/successful-pairs-of-spells-and-potions/?envType=study-plan-v2&envId=leetcode-75
 */
fun main() {
    println(SuccessfulPair().successfulPairs(intArrayOf(5, 1, 3), intArrayOf(1, 2, 3, 4, 5), 7))
}

class SuccessfulPair {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val result = IntArray(spells.size)
        Arrays.sort(potions)
        for (i in spells.indices) {
            var l = 0
            var r = potions.size - 1
            while (l <= r) {
                val mid = l + (r - l) / 2
                val potion = potions[mid]
                val strength = potion.toLong() * spells[i]

                if (strength >= success) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            }
            result[i] = potions.size - l
        }
        return result
    }
}