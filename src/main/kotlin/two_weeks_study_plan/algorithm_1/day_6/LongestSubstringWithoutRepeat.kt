package two_weeks_study_plan.algorithm_1.day_6

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/longest-substring-without-repeating-characters/?envType=study-plan&id=algorithm-i
 */

fun main() {
    print(LongestSubstringWithoutRepeat().lengthOfLongestSubstring("abcabcbb"))
}

class LongestSubstringWithoutRepeat {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        var subString = ""
        var max = 0

        for (i in s.indices) {
            if (subString.contains(s[i]).not()) {
                subString += (s[i])
                val length = subString.length
                if (length > max) max = length
            } else {
                subString = subString.substring(subString.indexOf(s[i]) + 1) + s[i]
            }
        }
        return max
    }
}