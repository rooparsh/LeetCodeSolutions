package two_weeks_study_plan.algorithm_1.day_13

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/power-of-two/?envType=study-plan&id=algorithm-i
 */
fun main() {
    print(PowerOfTwo().isPowerOfTwo(1))
}

class PowerOfTwo {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 0) return false

        var x = n
        while (x != 1) {
            if (x % 2 != 0) return false
            x /= 2
        }
        return true
    }
}