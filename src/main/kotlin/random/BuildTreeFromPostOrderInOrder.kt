package random

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */

fun main() {
    print(
        BuildTreeFromPostOrderInOrder().buildTree(
            intArrayOf(9, 3, 15, 20, 7),
            intArrayOf(9, 15, 7, 20, 37)
        )?.`val`
    )
}

class BuildTreeFromPostOrderInOrder {

    var rootIndex = 0
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        rootIndex = postorder.size - 1
        return build(inorder, postorder, 0, postorder.size - 1)
    }

    private fun build(inorder: IntArray, postorder: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        val rootValue = postorder[rootIndex--]
        val i = inorder.indexOf(rootValue)
        val root = TreeNode(rootValue)
        if (start == end) return root
        root.right = build(inorder, postorder, i + 1, end)
        root.left = build(inorder, postorder, start, i - 1)
        return root
    }
}