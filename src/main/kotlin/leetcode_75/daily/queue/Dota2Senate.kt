package leetcode_75.daily.queue

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/dota2-senate/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    predictPartyVictory("RDD")
}

fun predictPartyVictory(senate: String): String {
    val rQ = LinkedList<Int>()
    val dQ = LinkedList<Int>()

    for (i in senate.indices) {
        (if (senate[i] == 'R') rQ else dQ).addLast(i)
    }

    while (!dQ.isEmpty() && !rQ.isEmpty()) {
        val voterQ = if (dQ.getFirst() < rQ.getFirst()) dQ else rQ
        voterQ.addLast(maxOf(dQ.getLast(), rQ.getLast()) + 1)
        dQ.removeFirst()
        rQ.removeFirst()
    }
    return if (rQ.isEmpty()) "Dire" else "Radiant"
}