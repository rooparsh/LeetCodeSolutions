package daily_challenge

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/count-complete-tree-nodes/
 */

class CompleteTreeNodes {
    fun countNodes(root: TreeNode?): Int {
        root ?: return 0
        if (root.left == null && root.right == null) return 1

        var counter = 0
        counter += root.left?.let { countNodes(it) } ?: 0
        counter += root.right?.let { countNodes(it) } ?: 0

        return counter + 1
    }
}