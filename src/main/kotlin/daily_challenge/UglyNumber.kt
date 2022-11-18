package daily_challenge

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/ugly-number/
 */

fun main() {
    print(UglyNumber().isUgly(6))
}

class UglyNumber {
    fun isUgly(num: Int): Boolean {
        if (num <= 0) return false
        if (num == 1 || num == 2 || num == 3 || num == 5) return true

        var n = num
        n = div(n, 5)
        n = div(n, 3)
        n = div(n, 2)
        return n == 1
    }

    fun div(num: Int, d: Int): Int {
        var n = num
        while (n % d == 0) {
            n /= d
        }
        return n
    }
}