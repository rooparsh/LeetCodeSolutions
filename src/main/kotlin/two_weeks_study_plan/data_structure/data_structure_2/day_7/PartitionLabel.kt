package two_weeks_study_plan.data_structure.data_structure_2.day_7

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/partition-labels/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(PartitionLabel().partitionLabels("abba").joinToString())
}

class PartitionLabel {
    fun partitionLabels(source: String): List<Int> {
        val parts = mutableListOf<Int>()

        val occurrence = mutableMapOf<Char, Int>()
        for ((index, letter) in source.withIndex()) {
            occurrence[letter] = index
        }

        var previous = 0
        var lastOccurrence = occurrence[source[0]]!!
        for (index in 1 until source.length) {
            val last = occurrence[source[index]]!!

            if (index <= lastOccurrence) {
                if (last >= lastOccurrence) {
                    lastOccurrence = last
                }
            } else {
                parts.add(lastOccurrence + 1 - previous)
                previous = lastOccurrence + 1
                lastOccurrence = last
            }
        }

        parts.add(lastOccurrence + 1 - previous)

        return parts
    }
}