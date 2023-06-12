package random

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/zigzag-conversion/
 */

fun main() {
    println(convert("PAYPALISHIRING", 3))
}

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) return s

    val rows = MutableList(numRows) { "" }
    var idx = 0
    first@ while (true) {
        for (iMod in 0 until numRows) {
            rows[iMod] = rows[iMod] + s[idx++]
            if (idx == s.length) break@first
        }
        for (iMod in numRows - 2 downTo 1) {
            rows[iMod] = rows[iMod] + s[idx++]
            if (idx == s.length) break@first
        }
    }
    return rows.joinToString("")
}