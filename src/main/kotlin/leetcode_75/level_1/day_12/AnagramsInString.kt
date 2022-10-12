package leetcode_75.level_1.day_12

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/find-all-anagrams-in-a-string/?envType=study-plan&id=level-1
 */

fun main() {
    print(AnagramsInString().findAnagrams2("abab", "ab").joinToString())
}

class AnagramsInString {
    fun findAnagrams(s: String, p: String): List<Int> {
        val windowLength = p.length

        val list = mutableListOf<Int>()

        for (i in 0..s.length - windowLength) {
            val isAnagram = s.substring(i, i + windowLength).toCharArray().apply { sort() }
                .contentEquals(p.toCharArray().apply { sort() })
            if (isAnagram) {
                list.add(i)
            }
        }

        return list
    }

    fun findAnagrams2(s: String, p: String): List<Int> {
        if (p.length > s.length) return emptyList()

        val indices = mutableListOf<Int>()
        val smap = IntArray(26)
        val pmap = IntArray(26)

        for (i in p.indices) {
            pmap[p[i] - 'a']++
            smap[s[i] - 'a']++
        }

        for (j in 0 until s.length - p.length) {
            if (smap contentEquals pmap) indices.add(j)
            smap[s[j + p.length] - 'a']++
            smap[s[j] - 'a']--
        }

        if (smap contentEquals pmap) indices.add(s.length - p.length)

        return indices
    }
}