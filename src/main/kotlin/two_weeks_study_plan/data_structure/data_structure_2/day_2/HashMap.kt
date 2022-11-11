package two_weeks_study_plan.data_structure.data_structure_2.day_2

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/design-hashmap/?envType=study-plan&id=data-structure-ii
 */

class HashMap {

    private val array = arrayOfNulls<Int>(1000001)

    fun put(key: Int, value: Int) {
        array[key] = value
    }

    fun get(key: Int): Int {
        return array[key] ?: -1
    }

    fun remove(key: Int) {
        array[key] = null
    }
}