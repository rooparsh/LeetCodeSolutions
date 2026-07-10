package leetcode_75.daily.array.tree

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    longestZigZag(TreeNode(23))
}

fun longestZigZag(root: TreeNode?): Int {
    return maxOf(longestZigZag(root, true, 0), longestZigZag(root, false, 0))
}

fun longestZigZag(root: TreeNode?, isLeft: Boolean, level: Int): Int {
    if (root == null) return level
    return if (isLeft) {
        root.left?.let {
            maxOf(longestZigZag(it, false, level + 1), longestZigZag(it, true, 0))
        } ?: level
    } else {
        root.right?.let {
            maxOf(longestZigZag(it, true, level + 1), longestZigZag(it, false, 0))
        } ?: level
    }
}