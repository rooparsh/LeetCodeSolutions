package leetcode_75.level_1.day_6

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/binary-tree-level-order-traversal/?envType=study-plan&id=level-1
 */
fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTreeTraversal {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = mutableListOf<List<Int>>()

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            result.add(queue.toList().map { it.`val` })
            for (i in queue.indices) {
                val current = queue.poll()
                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }

            }
        }

        return result
    }
}