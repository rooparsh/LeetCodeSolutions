package two_weeks_study_plan.data_structure.data_structure_2.day_7

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/word-pattern/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(WordPattern().wordPattern("abba", "dog cat cat fish"))
}

class WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        val patternMap = mutableMapOf<Char, String>()

        val set1 = mutableSetOf<Char>()
        val set2 = mutableSetOf<String>()

        val words = s.split(" ")

        if (words.size != pattern.length) return false

        for (indx in words.indices) {

            set1.add(pattern[indx])
            set2.add(words[indx])

            if (patternMap.containsKey(pattern[indx])) {
                if (words[indx] != patternMap[pattern[indx]]) return false
            } else {
                patternMap.put(pattern[indx], words[indx])
            }
        }

        return set1.size == set2.size

    }
}