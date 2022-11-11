package two_weeks_study_plan.data_structure.data_structure_2.day_15

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan&id=data-structure-ii
 */

class SortedArrayToBinaryTree {
    fun sortedArrayToBST(nums: IntArray, start: Int = 0, end: Int = nums.size - 1): TreeNode? {
        if (start > end) return null
        val mid = (start + end) / 2
        val node = TreeNode(nums[mid])
        node.left = sortedArrayToBST(nums, start, mid - 1)
        node.right = sortedArrayToBST(nums, mid + 1, end)
        return node
    }
}