package two_weeks_study_plan.data_structure_2.day_16

import util.TreeNode
import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan&id=data-structure-ii
 */

fun main() {

    val level1Left = TreeNode(1)
    val level1Right = TreeNode(3)
    val root = TreeNode(2).apply {
        left = level1Left
        right = level1Right
    }

    print(RightSideBinaryTree().rightSideView(root).joinToString())
}

class RightSideBinaryTree {

    private fun levelOrderTraversal(root: TreeNode?): List<List<Int>> {
        val queue: Queue<TreeNode> = LinkedList()
        val result = mutableListOf<List<Int>>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val level = mutableListOf<Int>()
            var size = queue.size

            while (size > 0) {
                val current = queue.poll()
                level.add(current.`val`)
                current.left?.let { queue.offer(it) }
                current.right?.let { queue.offer(it) }
                size--
            }

            result.add(level)
        }

        return result
    }

    fun rightSideView(root: TreeNode?): List<Int> {
        root ?: return emptyList()
        return levelOrderTraversal(root).map { it.last() }
    }

    fun rightSideView2(root: TreeNode?): List<Int> {
        val result = ArrayList<Int>()
        rightPreorderTravers(result, root, 0)
        return result
    }


    private fun rightPreorderTravers(result: ArrayList<Int>, node: TreeNode?, level: Int) {
        if (node == null) {
            return
        }
        if (result.size == level) {
            result.add(node.`val`)
        }

        rightPreorderTravers(result, node.right, level + 1)
        rightPreorderTravers(result, node.left, level + 1)
    }

}