package two_weeks_study_plan.algorithm_1.day_11

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/letter-case-permutation/?envType=study-plan&id=algorithm-i
 */

fun main() {
    print(LetterCasePermutations().letterCasePermutation("a1b2").joinToString())
}

class LetterCasePermutations {
    fun letterCasePermutation(s: String): List<String> {
        var res = mutableListOf("")
        s.forEach { c ->
            val next = mutableListOf<String>()
            while (res.isNotEmpty()) {
                val str = res.removeAt(0)
                if (c.isDigit()) {
                    next.add(str + c)
                } else {
                    next.add(str + c.toLowerCase())
                    next.add(str + c.toUpperCase())
                }
            }
            res = next
        }
        return res
    }
}