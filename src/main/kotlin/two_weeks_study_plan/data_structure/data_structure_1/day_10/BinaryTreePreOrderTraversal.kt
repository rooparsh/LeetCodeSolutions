package two_weeks_study_plan.data_structure.data_structure_1.day_10

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/implement-queue-using-stacks/?envType=study-plan&id=data-structure-i
 */

class BinaryTreePreOrderTraversal {
    fun preorderTraversal(root: TreeNode?, list: MutableList<Int> = mutableListOf()): List<Int> {
        root ?: return list
        list.add(root.`val`)

        if (root.left != null) {
            preorderTraversal(root.left, list)
        }

        if (root.right != null) {
            preorderTraversal(root.right, list)
        }

        return list
    }
}