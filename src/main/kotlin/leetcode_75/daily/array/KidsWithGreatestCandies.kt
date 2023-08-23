package leetcode_75.daily.array

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    println(kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3))
}

fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    var maxCandies = 0
    candies.forEach { candy ->
        if (candy >= maxCandies) {
            maxCandies = candy
        }
    }

    val result = ArrayList<Boolean>()

    candies.forEach { candy ->
        result.add(candy + extraCandies >= maxCandies)
    }

    return result.toList()
}