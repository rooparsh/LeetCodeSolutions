package random

import kotlin.math.max
import kotlin.math.min

/**
 * Difficulty : Medium
 * Problem Statement : https://www.codingninjas.com/codestudio/library/smallest-difference-triplet-from-three-arrays
 */

fun main() {
    println(happyTriplet(intArrayOf(4, 3, 7), intArrayOf(21, 5, 11), intArrayOf(2, 6, 10)).joinToString())
}

fun happyTriplet(array1: IntArray, array2: IntArray, array3: IntArray): IntArray {

    val list = IntArray(3)

    val size = array1.size

    array1.sort()
    array2.sort()
    array3.sort()

    var i = 0
    var j = 0
    var k = 0

    var diff = Int.MAX_VALUE


    while (i < size && j < size && k < size) {
        val currSum = array1[i] + array2[j] + array3[k]
        val min = min(min(array1[i], array2[j]), array3[k])
        val max = max(max(array1[i], array2[j]), array3[k])
        val currDiff = max - min

        when (min) {
            array1[i] -> i++
            array2[j] -> j++
            else -> k++
        }

        if (currDiff < diff) {
            diff = currDiff

            list[0] = min
            list[1] = currSum - min - max
            list[2] = max
        }
    }



    return list
}