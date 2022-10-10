package leetcode_75.level_1.day_10

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/fibonacci-number/?envType=study-plan&id=level-1
 */
fun main() {
    print(FibonacciSeries().fib(10))
}

class FibonacciSeries {
    fun fib(n: Int): Int {
        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return 1
        }

        var x = 0
        x += fib(n - 1) + fib(n - 2)
        return x
    }
}