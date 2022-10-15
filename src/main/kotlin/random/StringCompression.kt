package random

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/string-compression-ii/
 */

fun main() {
    print(StringCompression().getLengthOfOptimalCompression("aaabcccd", 2))
}

class StringCompression {
    private companion object {
        private const val UNDEFINED = -1
    }

    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        val numberLength = IntArray(s.length + 2) { num -> num.toString().length }
        numberLength[0] = 0
        numberLength[1] = 0

        val mem = Array(s.length) { IntArray(k + 1) { UNDEFINED } }

        fun getMinLength(pos: Int, canDelete: Int): Int {
            if (pos == -1) {
                return 0
            }

            if (mem[pos][canDelete] != UNDEFINED) {
                return mem[pos][canDelete]
            }

            var result = Int.MAX_VALUE

            if (canDelete > 0) {
                result = minOf(result, getMinLength(pos - 1, canDelete - 1))
            }

            val curChar = s[pos]
            var deleted = 0
            var length = 0

            for (i in pos downTo 0) {
                if (s[i] == curChar) {
                    ++length
                } else {
                    if (deleted == canDelete) break
                    ++deleted
                }

                result = minOf(result, getMinLength(i - 1, canDelete - deleted) + 1 + numberLength[length])
            }

            mem[pos][canDelete] = result
            return result
        }

        return getMinLength(s.lastIndex, k)

    }
}