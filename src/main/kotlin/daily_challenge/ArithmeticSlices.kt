package daily_challenge

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
 */

fun main() {
    println(ArithmeticSlices().numberOfArithmeticSlices(intArrayOf(2, 4, 6, 8, 10)))
}

class ArithmeticSlices {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        val n: Int = nums.size

        val counts: Array<HashMap<Int, Int>?> = arrayOfNulls(n)


        var totalCount = 0

        for (end in 0 until n) {
            counts[end] = HashMap(end)
            for (start in 0 until end) {
                val diffInLong = nums[end].toLong() - nums[start].toLong()

                if (diffInLong < Int.MIN_VALUE || diffInLong > Int.MAX_VALUE) continue

                val diff = diffInLong.toInt()
                val count = counts[start]!!.getOrDefault(diff, 0)

                totalCount += count
                val prevCount = counts[end]!!.getOrDefault(diff, 0)

                counts[end]!![diff] = prevCount + count + 1
            }
        }


        return totalCount
    }
}