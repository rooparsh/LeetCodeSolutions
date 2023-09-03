package leetcode_75.daily.array.tree

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {

}

fun maxDepth(root: TreeNode?): Int {
    root ?: return 0
    return maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
}