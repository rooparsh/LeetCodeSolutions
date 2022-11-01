package two_weeks_study_plan.data_structure_2.day_17

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/kth-smallest-element-in-a-bst/?envType=study-plan&id=data-structure-ii
 */

fun main() {

    val level1Left = TreeNode(1)
    val level1Right = TreeNode(3)
    val root = TreeNode(2).apply {
        left = level1Left
        right = level1Right
    }

    print(KthSmallestInBinaryTree().kthSmallest(root, 2))
}


class KthSmallestInBinaryTree {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val list = mutableListOf<Int>()
        inOrderTraversal(root, list)
        return list[k - 1]
    }

    private fun inOrderTraversal(root: TreeNode?, result: MutableList<Int>) {
        root ?: return

        root.left?.let {
            inOrderTraversal(it, result)
        }

        result.add(root.`val`)

        root.right?.let {
            inOrderTraversal(it, result)
        }
    }
}