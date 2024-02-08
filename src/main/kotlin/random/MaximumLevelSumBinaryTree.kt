package random

import util.TreeNode
import java.util.ArrayDeque

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 */
fun maxLevelSum(root: TreeNode?): Int {
    root ?: return -1

    var levelCounter = 1
    val queue = ArrayDeque<TreeNode>()

    queue.add(root)
    var maxSum = root.`val`
    var maxLevel = levelCounter

    while (queue.isEmpty().not()) {
        val levelSize = queue.size
        var levelSum = 0
        for (i in 0 until levelSize) {
            val node = queue.removeFirst()
            levelSum += node.`val`
            node.left?.let { queue.add(node.left) }
            node.right?.let { queue.add(node.right) }

        }

        if (maxSum < levelSum) {
            maxSum = levelSum
            maxLevel = levelCounter
        }

        levelCounter++
    }

    return maxLevel
}