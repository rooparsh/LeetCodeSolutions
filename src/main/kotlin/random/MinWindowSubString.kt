package random

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/minimum-window-substring/
 */

fun main() {
    print(MinWindowSubString().minWindow("ADOBECODEBANC", "ABC"))
}

class MinWindowSubString {
    fun minWindow(s: String, t: String): String {
        val neededLetterCount = t.fold(mutableMapOf<Char, Int>()) { acc, c ->
            acc[c] = (acc[c] ?: 0) + 1
            acc
        }

        fun isTargetMeet() = neededLetterCount.all { it.value <= 0 }

        var subStringRange = 0..-1


        var i = 0
        for (j in 0..s.lastIndex) {
            if (neededLetterCount.containsKey(s[j])) {
                neededLetterCount[s[j]] = neededLetterCount[s[j]]!! - 1
                while (isTargetMeet()) {
                    if (subStringRange.isEmpty() || j - i < subStringRange.last - subStringRange.first) {
                        subStringRange = i..j
                    }
                    if (neededLetterCount.containsKey(s[i])) {
                        neededLetterCount[s[i]] = neededLetterCount[s[i]]!! + 1
                    }
                    ++i
                }
            }
        }

        return s.substring(subStringRange)
    }
}