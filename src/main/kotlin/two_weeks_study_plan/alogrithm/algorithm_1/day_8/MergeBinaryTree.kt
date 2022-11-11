package two_weeks_study_plan.alogrithm.algorithm_1.day_8

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/merge-two-binary-trees/?envType=study-plan&id=algorithm-i
 */
class MergeBinaryTree {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {

        root1 ?: return root2
        root2 ?: return root1

        return root1.apply {
            `val` += root2.`val`
            left = mergeTrees(left, root2.left)
            right = mergeTrees(right, root2.right)
        }

    }
}