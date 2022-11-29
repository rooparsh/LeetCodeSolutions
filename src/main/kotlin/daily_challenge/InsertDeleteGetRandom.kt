package daily_challenge

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/insert-delete-getrandom-o1/
 */

class InsertDeleteGetRandom {

    private val set = mutableSetOf<Int>()

    fun insert(`val`: Int): Boolean {
        return set.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return set.remove(`val`)
    }

    fun getRandom(): Int {
        return set.random()
    }

}