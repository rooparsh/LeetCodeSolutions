package leetcode_75.level_1.day_14

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/decode-string/?envType=study-plan&id=level-1
 */
fun main() {
    print(DecodeString().decodeString("3[a]2[bc]"))
}

class DecodeString {
    fun decodeString(s: String): String {
        return decode(s, 0).first
    }

    private fun decode(s: String, i: Int): Pair<String, Int> {
        val result = StringBuilder()
        val numberSB = StringBuilder()
        var index = i

        while (index < s.length && s[index] != ']') {
            if (s[index].isDigit()) {
                numberSB.append(s[index])
                index++
            } else if (s[index] == '[') {
                val repeatNum = numberSB.toString().toInt()
                numberSB.clear()
                val (decodeStr, newIndex) = decode(s, index + 1)
                result.append(
                    repeat(
                        decodeStr,
                        repeatNum
                    )
                )
                index = newIndex
            } else {
                result.append(s[index])
                index++
            }
        }

        return Pair(result.toString(), index + 1)
    }

    private fun repeat(s: String, n: Int): String {
        return s.repeat(n)
    }
}