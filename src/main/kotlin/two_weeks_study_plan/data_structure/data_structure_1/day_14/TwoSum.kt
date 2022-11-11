package two_weeks_study_plan.data_structure.data_structure_1.day_14

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/?envType=study-plan&id=data-structure-i
 */

class TwoSum {
    private val map = mutableMapOf<Int, Int>()
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        root ?: return false
        if (map[k - root.`val`] != null) return true
        map[root.`val`] = 1
        return findTarget(root.left, k) || findTarget(root.right, k)
    }
}