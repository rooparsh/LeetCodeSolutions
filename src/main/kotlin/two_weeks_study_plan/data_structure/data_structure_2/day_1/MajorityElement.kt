package two_weeks_study_plan.data_structure.data_structure_2.day_1

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/majority-element/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    println(MajorityElement().majorityElement2(intArrayOf(3, 2, 3)))
}

class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val frequencyMap = nums.groupBy { it }.map { (key, value) -> key to value.size }.toMap()

        return frequencyMap.maxByOrNull { it.value }!!.key
    }

    fun majorityElement2(nums: IntArray): Int {
        var count = 0
        var candidate: Int? = null

        nums.forEach {
            if (count == 0) candidate = it

            count += if (candidate == it) 1 else -1
        }
        return candidate!!
    }

}