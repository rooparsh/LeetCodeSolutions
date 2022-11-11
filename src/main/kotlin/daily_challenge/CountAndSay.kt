package daily_challenge

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/count-and-say/
 */

fun main() {
    print(CountAndSay().countAndSay(1211))
}

class CountAndSay {

    fun countAndSay(n: Int): String {
        // our function to generate the next term of the sequence
        fun next(s: String): String {

            var res = ""
            var count: Int
            var i = 0
            while (i<s.length) {
                count = 1
                while (i+1<s.length && s[i]==s[i+1]) {
                    i++
                    count++
                }
                res += "$count${s[i++]}"
            }
            return res
        }
        // create the sequence, starting with "1", return the nth element
        return generateSequence("1", ::next).take(n).last()

    }
}