package daily_challenge

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/unique-number-of-occurrences/
 */

fun main() {
    print(UniqueOccurrences().uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)))
}

class UniqueOccurrences {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = arr.toList().groupingBy { it }.eachCount()

        val uniqueKeysCount = map.keys.size
        val uniqueValuesCount = map.values.distinct().size
        return uniqueKeysCount == uniqueValuesCount
    }
}