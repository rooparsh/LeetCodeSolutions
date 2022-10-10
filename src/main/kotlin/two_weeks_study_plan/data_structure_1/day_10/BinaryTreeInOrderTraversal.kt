package two_weeks_study_plan.data_structure_1.day_10

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/binary-tree-inorder-traversal/?envType=study-plan&id=data-structure-i
 */

class BinaryTreeInOrderTraversal {
    fun inorderTraversal(root: TreeNode?, list: MutableList<Int> = mutableListOf()): List<Int> {
        root ?: return list

        if (root.left != null) {
            inorderTraversal(root.left, list)
        }

        list.add(root.`val`)


        if (root.right != null) {
            inorderTraversal(root.right, list)
        }

        return list
    }
}