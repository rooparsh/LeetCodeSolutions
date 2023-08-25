package leetcode_75.daily.array

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')))
}

fun compress(chars: CharArray): Int {
    if (chars.isEmpty()) return 0
    var idx = 0
    var i = 0
    while (i < chars.size) {
        val ch = chars[i]
        var count = 0
        while (i < chars.size && chars[i] == ch) {
            count += 1
            i += 1
        }
        chars[idx] = ch
        idx += 1
        //keep digits of count in chars
        if(count > 1) {
            for (digit in count.toString().toCharArray()) {
                chars[idx] = digit
                idx += 1
            }
        }
    }
    //println(chars)
    return idx
}