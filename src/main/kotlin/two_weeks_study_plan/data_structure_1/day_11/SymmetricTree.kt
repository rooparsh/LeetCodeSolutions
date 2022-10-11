package two_weeks_study_plan.data_structure_1.day_11

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/symmetric-tree/?envType=study-plan&id=data-structure-i
 */

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        root ?: return true
        return helper(root.left, root.right)
    }

    private fun helper(root: TreeNode?, flip: TreeNode?): Boolean {
        if (root == null && flip == null) {
            return true
        }

        if (root == null || flip == null) {
            return false
        }
        if (root.`val` != flip.`val`) {
            return false
        }

        return helper(root.left, flip.right) && helper(root.right, flip.left)
    }
}