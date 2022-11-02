package random

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/minimum-genetic-mutation/
 */

fun main() {
    println(
        MinimumGeneMutation().minMutation(
            "AAAAACCC", "AACCCCCC", arrayOf("AAAACCCC", "AAACCCCC", "AACCCCCC")
        )
    )
}

class MinimumGeneMutation {
    fun minMutation(start: String, end: String, bank: Array<String>): Int {
        val dictionary = bank.toMutableSet()

        if (start == end || dictionary.contains(end).not()) return -1
        val genes = listOf('A', 'C', 'G', 'T')

        val queue: Queue<String> = LinkedList()
        queue.add(start)

        var level = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            repeat(size) {
                val node = queue.poll()
                if (node == end) return level

                val nodeChars = node.toCharArray()

                repeat(8) { i ->
                    val temp = nodeChars[i]
                    for (newGene in genes) {
                        if (newGene != nodeChars[i]) {
                            nodeChars[i] = newGene
                            val str = String(nodeChars)
                            if (dictionary.contains(str)) {
                                dictionary.remove(str)
                                queue.add(str)
                            }
                        }
                    }
                    nodeChars[i] = temp
                }
            }
            level++
        }
        return -1
    }
}