package two_weeks_study_plan.data_structure_1.day_12

import util.TreeNode


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/invert-binary-tree/?envType=study-plan&id=data-structure-i
 */


class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        return root?.apply {
            left = right.also { right = left }
            invertTree(left)
            invertTree(right)
        }
    }
}