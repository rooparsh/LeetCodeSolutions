package two_weeks_study_plan.data_structure_2.day_21

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/k-closest-points-to-origin/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    println(
        KClosestPointsToOrigin().kClosest(
            arrayOf(
                intArrayOf(3, 3),
                intArrayOf(5, -1),
                intArrayOf(-2, 4),
            ), 2
        ).joinToString()
    )
}

class KClosestPointsToOrigin {

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<IntArray>(compareByDescending { distance(it) })

        for (point in points) {
            maxHeap.offer(point)
            if (maxHeap.size > k) maxHeap.poll()
        }

        return maxHeap.toTypedArray()
    }

    private fun distance(point: IntArray): Int {
        return point[0] * point[0] + point[1] * point[1]
    }


    fun kClosest2(points: Array<IntArray>, k: Int): Array<IntArray> {
        return points.sortedBy { it[0] * it[0] + it[1] * it[1] }.take(k).toTypedArray()
    }
}