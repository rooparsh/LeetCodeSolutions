package leetcode_75.daily.array

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
}

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var count = 0

    flowerbed.forEachIndexed { index, flower ->
        if (flower == 0) {
            val isLeftEmpty = index == 0 || (flowerbed[index - 1] == 0)
            val isRightEmpty = index == flowerbed.size - 1 || (flowerbed[index + 1] == 0)

            if (isLeftEmpty && isRightEmpty) {
                flowerbed[index] = 1
                count++
            }
        }
    }

    return count >= n
}