package two_weeks_study_plan.algorithm_1.day_1

fun main() {
    val array = arrayOf(9).toIntArray()
    println(BinarySearch().search(array, 9))
}

class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var startIndex = 0
        var endIndex = nums.size - 1

        while (startIndex <= endIndex) {
            val center = (startIndex + endIndex) / 2

            if (target == nums[center]) {
                return center
            } else if (target > nums[center]) {
                startIndex = center + 1
            } else if (target < nums[center]) {
                endIndex = center - 1
            }
        }

        return -1
    }
}