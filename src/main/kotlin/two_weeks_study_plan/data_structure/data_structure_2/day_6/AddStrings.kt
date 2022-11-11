package two_weeks_study_plan.data_structure.data_structure_2.day_6

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/add-strings/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(AddStrings().addStrings("11", "123"))
}

class AddStrings {
    fun addStrings(num1: String, num2: String) = (num1.toBigInteger() + num2.toBigInteger()).toString()


    fun addStrings2(num1: String, num2: String): String {
        var i: Int = num1.length - 1
        var j: Int = num2.length - 1
        var carry = 0
        val sb = StringBuilder()
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry += num1[i--] - '0'
            if (j >= 0) carry += num2[j--] - '0'
            sb.append(carry % 10)
            carry /= 10
        }
        return sb.reverse().toString()
    }
}