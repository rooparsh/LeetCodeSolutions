package two_weeks_study_plan.algorithm_1.day_13

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/number-of-1-bits/?envType=study-plan&id=algorithm-i
 */

fun main() {
    print(NumberOfOneBit().hammingWeight(8))
}

class NumberOfOneBit {
    fun hammingWeight(n: Int): Int = Integer.toBinaryString(n).filter { it == '1' }.length

    fun hammingWeight2(n: Int): Int {
        var count = 0
        var x = n


        for (i in 0..31) {
            if (x != 0) {
                x = x and (x - 1)
                count++
            }
        }
        return count
    }

}