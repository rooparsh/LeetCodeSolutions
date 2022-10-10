package two_weeks_study_plan.data_structure_1.day_10

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/binary-tree-postorder-traversal/?envType=study-plan&id=data-structure-i
 */

class BinaryTreePostOrderTraversal {
    fun postorderTraversal(root: TreeNode?, list: MutableList<Int> = mutableListOf()): List<Int> {
        root ?: return list

        if (root.left != null) {
            postorderTraversal(root.left, list)
        }

        if (root.right != null) {
            postorderTraversal(root.right, list)
        }
        list.add(root.`val`)
        return list
    }
}