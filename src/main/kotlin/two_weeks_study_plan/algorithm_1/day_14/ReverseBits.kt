package two_weeks_study_plan.algorithm_1.day_14

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/reverse-bits/?envType=study-plan&id=algorithm-i
 */
fun main() {
    print(ReverseBits().reverseBits(43261596))
}

class ReverseBits {
    fun reverseBits(n: Int): Int {
        var result = 0

        for (i in 0..31)
            result = (result shl 1) or ((n ushr i) and 1)

        return result
    }
}