package two_weeks_study_plan.data_structure.data_structure_1.day_12

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/path-sum/?envType=study-plan&id=data-structure-i
 */

class PathSum {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        root ?: return false
        if (root.left == null && root.right == null && root.`val` == targetSum) return true
        return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
    }
}