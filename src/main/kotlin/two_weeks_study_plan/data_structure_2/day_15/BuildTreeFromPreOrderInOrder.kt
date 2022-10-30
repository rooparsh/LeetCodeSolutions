package two_weeks_study_plan.data_structure_2.day_15

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

fun main() {
    print(BuildTreeFromPreOrderInOrder().buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))?.`val`)
}

class BuildTreeFromPreOrderInOrder {
    var preIndex: Int = 0
    fun buildTree(
        preorder: IntArray,
        inorder: IntArray,
        start: Int = 0,
        end: Int = inorder.size - 1
    ): TreeNode? {

        if (start > end) return null
        val item = preorder[preIndex++]
        val node = TreeNode(item)

        if (start == end) return node

        val indexOfNodeInInOrder = inorder.indexOf(item)

        node.left = buildTree(preorder, inorder, start, indexOfNodeInInOrder - 1)
        node.right = buildTree(preorder, inorder, indexOfNodeInInOrder + 1, end)
        return node
    }
}