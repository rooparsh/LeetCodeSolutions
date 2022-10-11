package two_weeks_study_plan.data_structure_1.day_11

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/maximum-depth-of-binary-tree/?envType=study-plan&id=data-structure-i
 */

class MaxDepthBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        root ?: return 0
        return maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}