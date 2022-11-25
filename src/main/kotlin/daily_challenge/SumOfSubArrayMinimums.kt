package daily_challenge

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/sum-of-subarray-minimums/
 */

fun main() {
    println(SumOfSubArrayMinimums().sumSubarrayMins(intArrayOf(3, 1, 2, 4)))
}

class SumOfSubArrayMinimums {

    companion object {
        private const val Modulo = 1000000007
    }

    private fun IntArray.computeSmallerItemsToTheRight(): IntArray {
        val smallerItemsToTheRight = IntArray(this.size) { this.size - (it + 1) }
        val minStack = ArrayDeque<Int>()

        //since we run on the array from the left
        //i is on the right of the indices we consider from the stack
        //so if the item on index i is smaller than them we can update
        //their position with the up to date count.
        for (i in 0 until this.size) {
            while (!minStack.isEmpty() && this[minStack.peek()] > this[i]) {
                smallerItemsToTheRight[minStack.peek()] = i - (minStack.peek() + 1)
                minStack.pop()
            }
            minStack.push(i)
        }

        return smallerItemsToTheRight
    }

    private fun IntArray.computeSmallerItemsToTheLeft(): IntArray {
        val smallerItemsToTheLeft = IntArray(this.size) { it }
        val minStack = ArrayDeque<Int>()

        //since we run on the array from the right
        //i is on the left of the indices we consider from the stack
        //so if the item on index i is smaller or equal to them we can update
        //their position with the up to date count.
        for (i in (this.size - 1) downTo 0) {
            while (!minStack.isEmpty() && this[minStack.peek()] >= this[i]) {
                smallerItemsToTheLeft[minStack.peek()] = minStack.peek() - (i + 1)
                minStack.pop()
            }
            minStack.push(i)
        }

        return smallerItemsToTheLeft
    }

    fun sumSubarrayMins(arr: IntArray): Int {
        val smallerItemsToTheLeft = arr.computeSmallerItemsToTheLeft()
        val smallerItemsToTheRight = arr.computeSmallerItemsToTheRight()

        var result: Long = 0
        for (i in arr.indices) {
            val current = arr[i].toLong() * (smallerItemsToTheRight[i] + 1) * (smallerItemsToTheLeft[i] + 1)
            result += current
        }
        return (result % Modulo).toInt()
    }
}