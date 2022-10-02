package leetcode_75.level_1.day_2


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/isomorphic-strings/?envType=study-plan&id=level-1
 */

fun main() {
    println(IsomorphicStrings().isIsomorphic("egg", "add"))
}


/**
 * s = egg , t = add
 *
 *
 * characterMap = [[e,t],[g,d]]
 * used = [[t, true]]
 */
class IsomorphicStrings {
    fun isIsomorphic(s: String, t: String): Boolean {
        val characterMap = mutableMapOf<Char, Char>()
        val used = mutableMapOf<Char, Boolean>()

        for (i in s.indices) {
            if (characterMap.contains(s[i])) {
                if (characterMap[s[i]] != t[i]) {
                    return false
                }
            } else {
                if (used.contains(t[i])) {
                    return false
                }
                characterMap[s[i]] = t[i]
                used[t[i]] = true
            }

        }

        return true

    }
}