package leetcode_75.level_1.day_12

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/longest-repeating-character-replacement/?envType=study-plan&id=level-1
 */

fun main() {
    print(LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2))
}

class LongestRepeatingCharacterReplacement {
    fun characterReplacement(s: String, k: Int): Int {
        val map = mutableMapOf<Char, Int>()
        var mostFreq = 0
        var start = 0
        var max = 0

        for (end in s.indices) {
            map[s[end]] = map.getOrDefault(s[end], 0) + 1
            mostFreq = maxOf(map[s[end]]!!, mostFreq)
            if (end - start + 1 > mostFreq + k) {
                map[s[start]] = map[s[start]]!! - 1
                start++
            }
            max = Math.max(max, end - start + 1)

        }
        return max
    }
}