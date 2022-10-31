package two_weeks_study_plan.data_structure_2.day_16

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/delete-node-in-a-bst/?envType=study-plan&id=data-structure-ii
 */

class DeleteNodeInBinaryTree {

    private fun findNodes(current: TreeNode?, key: Int, prev: TreeNode? = null): Pair<TreeNode?, TreeNode>? {
        if (current == null) {
            return null
        }
        return if (key > current.`val`) {
            findNodes(current.right, key, current)
        } else if (key < current.`val`) {
            findNodes(current.left, key, current)
        } else {
            prev to current
        }
    }

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        val nodes = findNodes(root, key) ?: return root
        var lastLeft = nodes.second.right
        while (lastLeft?.left != null) {
            lastLeft = lastLeft.left
        }
        lastLeft?.left = nodes.second.left
        nodes.first?.let { prev ->
            if (prev.left == nodes.second) {
                prev.left = nodes.second.right ?: nodes.second.left
            } else {
                prev.right = nodes.second.right ?: nodes.second.left
            }
        } ?: return nodes.second.right ?: nodes.second.left
        return root
    }
}