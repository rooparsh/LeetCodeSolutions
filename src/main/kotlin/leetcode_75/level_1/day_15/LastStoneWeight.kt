package leetcode_75.level_1.day_15

import java.util.*

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/last-stone-weight/?envType=study-plan&id=level-1
 */

fun main() {
    println(LastStoneWeight().lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
}

class LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        if (stones.isEmpty()) return 0
        if (stones.size == 1) return stones.first()

        val heap = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
        heap.addAll(stones.asList())

        while (heap.size > 1) {
            val first = heap.remove()
            val second = heap.remove()
            if (first > second) heap.add(first - second)
        }

        return if (heap.isEmpty()) 0 else heap.remove()
    }
}