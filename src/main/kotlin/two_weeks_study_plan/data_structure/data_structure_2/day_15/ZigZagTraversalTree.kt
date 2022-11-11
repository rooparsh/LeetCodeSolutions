package two_weeks_study_plan.data_structure.data_structure_2.day_15

import util.TreeNode
import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/?envType=study-plan&id=data-structure-ii
 */

class ZigZagTraversalTree {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val queue: Queue<TreeNode> = LinkedList()
        val result = mutableListOf<LinkedList<Int>>()
        if (root == null) return result
        var leftToRight = true // if true, add elements in normally else add in reverse
        queue.add(root)
        while (queue.isNotEmpty()) {
            val thisLevel = LinkedList<Int>()
            var size = queue.size
            while (size > 0) {
                val current = queue.poll()
                if (leftToRight.not()) thisLevel.addFirst(current.`val`) // reverse
                else thisLevel.add(current.`val`) // normal
                current.left?.let { queue.offer(it) }
                current.right?.let { queue.offer(it) }
                --size
            }
            result.add(thisLevel)
            leftToRight = leftToRight.not()
        }
        return result
    }
}