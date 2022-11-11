package two_weeks_study_plan.data_structure.data_structure_1.day_2

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/merge-sorted-array/?envType=study-plan&id=data-structure-i
 */

fun main() {

    val array1 = arrayOf(1, 2, 3, 0, 0, 0).toIntArray()
    val array2 = arrayOf(2, 5, 6).toIntArray()

    MergeSortedArray().merge(array1, 3, array2, 3)

    print(array1.joinToString())

}

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var firstArrayLast = m - 1
        var secondArrayLast = n - 1

        var left = nums1.size - 1

        while (left >= 0) {
            if (secondArrayLast < 0) break

            if (firstArrayLast >= 0 && nums1[firstArrayLast] > nums2[secondArrayLast]) {
                nums1[left] = nums1[firstArrayLast--]
            } else {
                nums1[left] = nums2[secondArrayLast--]
            }
            left--
        }
    }
}