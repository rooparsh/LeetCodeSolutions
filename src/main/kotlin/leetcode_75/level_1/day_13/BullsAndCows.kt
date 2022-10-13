package leetcode_75.level_1.day_13

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/bulls-and-cows/?envType=study-plan&id=level-1
 */

fun main() {
    print(BullsAndCows().getHint("1807", "7810"))
}

class BullsAndCows {

    fun getHint(secret: String, guess: String): String {
        val s = IntArray(10)
        val g = IntArray(10)
        var (bulls, cows) = 0 to 0
        for (n in secret) s[n - '0']++
        for (n in guess) g[n - '0']++
        for (i in s.indices) {
            cows += if (s[i] == g[i]) s[i]
            else minOf(s[i], g[i])
        }
        for (i in secret.indices) {
            if (secret[i] == guess[i]) bulls++
        }
        return "${bulls}A${Math.abs(cows - bulls)}B"
    }
}