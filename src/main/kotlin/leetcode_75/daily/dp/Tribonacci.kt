package leetcode_75.daily.dp

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=leetcode-75
 *
 */
fun main() {
    println(Tribonacci().tribonacci(25))
}

class Tribonacci {
    fun tribonacci(n: Int): Int {
        if (n == 0) return 0
        if (n == 1 || n == 2) return 1
        var a = 0
        var b = 1
        var c = 1
        for (i in 3..n) {
            val next = a + b + c
            a = b
            b = c
            c = next
        }
        return c
    }
}