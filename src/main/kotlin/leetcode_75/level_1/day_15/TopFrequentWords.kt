package leetcode_75.level_1.day_15

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/top-k-frequent-words/?envType=study-plan&id=level-1
 */

fun main() {
    print(TopFrequentWords().topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2))
}

class TopFrequentWords {
    fun topKFrequent(words: Array<String>, k: Int) = words
        .groupingBy { it }
        .eachCount()
        .toList()
        .sortedWith(compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first })
        .map { it.first }
        .subList(0, k)


    fun topKFrequent2(words: Array<String>, k: Int): List<String> {
        val frequencies = words.groupingBy { it }.eachCount()
        val comparator = object : Comparator<Pair<String, Int>> {
            override fun compare(o1: Pair<String, Int>?, o2: Pair<String, Int>?): Int {
                if (o1 == o2) return 0
                if (o1 != null && o2 != null) {
                    return if (o1.second == o2.second) if (o1.first > o2.first) 1 else -1
                    else if (o1.second > o2.second) -1 else 1
                }
                return -1
            }

        }

        val heap = PriorityQueue(comparator)
        frequencies.forEach { (word, count) -> heap.add(word to count) }
        val result = mutableListOf<String>()
        repeat(k) { result += heap.remove().first }
        return result
    }
}