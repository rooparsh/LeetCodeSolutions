package two_weeks_study_plan.data_structure.data_structure_1.day_3

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/intersection-of-two-arrays-ii/?envType=study-plan&id=data-structure-i
 */

fun main() {

    val array1 = intArrayOf(1, 2, 2, 1)
    val array2 = intArrayOf(2, 2)

    print(IntersectionOf2Arrays().intersect(array1, array2).joinToString())

}

class IntersectionOf2Arrays {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val frequencyMap = HashMap<Int, Int>()
        val array = mutableListOf<Int>()
        nums1.map { frequencyMap[it] = frequencyMap[it]?.plus(1) ?: 1 }

        nums2.forEach {
            if (frequencyMap[it] != null && frequencyMap[it] != 0) {
                array.add(it)
                frequencyMap[it] = frequencyMap[it]?.minus(1) ?: 0
            }
        }

        return array.toIntArray()
    }
}