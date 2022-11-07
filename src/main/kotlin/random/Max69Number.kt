package random

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/maximum-69-number/
 */

fun main() {
    println(Max69Number().maximum69Number2(9669))
}

class Max69Number {
    fun maximum69Number(num: Int): Int = num.toString().replaceFirst("6", "9").toInt()


    fun maximum69Number2(num: Int): Int {
        var indexSix = -1
        var temp = num
        var counter = 0

        while (temp > 0) {
            if (temp % 10 == 6) {
                indexSix = counter
            }
            temp /= 10
            counter++
        }

        return if (indexSix == -1) {
            num
        } else {
            num + 3 * Math.pow(10.0, indexSix.toDouble()).toInt()
        }
    }
}