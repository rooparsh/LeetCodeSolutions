package two_weeks_study_plan.data_structure.data_structure_2.day_8

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/multiply-strings/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(MultiplyStrings().multiply("123", "456"))
}

class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"
        val number1 = StringBuilder(num1).reversed().toString()
        val number2 = StringBuilder(num2).reversed().toString()
        val len1 = number1.length
        val len2 = number2.length

        val sums = IntArray(len1 + len2)

        for (i in 0 until len1) {
            val a = number1[i] - '0'
            for (j in 0 until len2) {
                val b = number2[j] - '0'
                sums[i + j] += a * b
            }
        }

        val res = StringBuilder()
        var carry = 0

        for (sum in sums) {
            val num = (sum + carry) % 10
            carry = (sum + carry) / 10
            res.append(num)
        }

        if (res.last() == '0') res.deleteCharAt(res.length - 1)
        return res.reversed().toString()

    }
}