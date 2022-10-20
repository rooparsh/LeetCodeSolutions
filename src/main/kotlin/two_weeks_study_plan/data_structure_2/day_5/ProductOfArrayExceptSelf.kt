package two_weeks_study_plan.data_structure_2.day_5

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(ProductOfArrayExceptSelf().productExceptSelf2(intArrayOf(-1, 1, 0, -3, 3)).joinToString())
}

class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val list = mutableListOf<Int>()
        var counter = 0
        var product = 1
        while (counter < nums.size) {
            nums.forEachIndexed { index, i ->
                if (index != counter)
                    product *= i
            }
            list.add(product)
            product = 1
            counter++
        }

        return list.toIntArray()
    }

    fun productExceptSelf2(nums: IntArray): IntArray {
        var prod = 1
        val ans = IntArray(nums.size) { 1 }
        for (i in nums.indices) {

            ans[i] = prod
            prod *= nums[i]
        }

        prod = 1

        for (i in nums.size - 1 downTo 0) {

            ans[i] *= prod
            prod *= nums[i]
        }

        return ans
    }
}