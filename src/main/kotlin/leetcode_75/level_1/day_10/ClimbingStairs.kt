package leetcode_75.level_1.day_10

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/climbing-stairs/?envType=study-plan&id=level-1
 */
fun main() {
    print(ClimbingStairs().climbStairs(4))
}

class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        tailrec fun fib(i: Int, first: Int, second: Int): Int =
            if (i == n)
                first + second
            else
                fib(i + 1, first = second, second = first + second)

        return fib(1, 0, 1)
    }
}