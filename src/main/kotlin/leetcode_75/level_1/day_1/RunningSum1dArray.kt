package leetcode_75.level_1.day_1



/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/running-sum-of-1d-array/?envType=study-plan&id=level-1
 */

fun main() {
    val array = arrayOf(1, 2, 3, 4).toIntArray()

    val result = RunningSum1dArray().runningSumApproach3(array)
    println(result.joinToString())
}

class RunningSum1dArray {

    /** Time complexity : O(n2)
     *  Space complexity : 0(n)
     **/
    fun runningSum(nums: IntArray): IntArray {
        val runningArray = IntArray(nums.size) { 0 }

        for (i in nums.indices) {
            for (j in 0..i) {
                runningArray[i] += nums[j]
            }
        }

        return runningArray
    }

    /** Time complexity : O(n)
     *  Space complexity : 0(n)
     **/
    fun runningSumApproach2(nums: IntArray): IntArray {
        val runningArray = IntArray(nums.size) { 0 }

        runningArray[0] = nums[0]
        for (i in 1 until nums.size) {
            runningArray[i] = runningArray[i - 1] + nums[i]
        }

        return runningArray
    }

    /** Time complexity : O(n)
     *  Space complexity : 0(1)
     **/
    fun runningSumApproach3(nums: IntArray): IntArray {
        for (i in 1 until nums.size) {
            nums[i] += nums[i - 1]
        }

        return nums
    }
}