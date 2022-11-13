package daily_challenge

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/reverse-words-in-a-string/
 */

fun main() {
    print(ReverseWordsInString().reverseWords("the sky is blue"))
}

class ReverseWordsInString {
    fun reverseWords2(s: String): String {
        val sb = StringBuilder()
        var i = s.length - 1
        while (i >= 0) {
            if (s[i] == ' ') {
                i--
                continue
            }
            val start = s.lastIndexOf(' ', i)
            sb.append(' ')
            sb.append(s, start + 1, i + 1)
            i = start - 1
        }
        if (sb.isNotEmpty()) {
            sb.deleteCharAt(0)
        }
        return sb.toString()

    }


    fun reverseWords(s: String): String {
        return if (s.isEmpty() or s.isBlank()) return ""
        else s.split(" ").filter { it.isNotBlank() }.reversed().joinToString(" ")
    }
}