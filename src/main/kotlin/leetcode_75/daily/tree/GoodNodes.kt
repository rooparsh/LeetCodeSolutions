package leetcode_75.daily.array.tree

import util.TreeNode
import kotlin.math.max

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 */

fun goodNodes(root: TreeNode?): Int {

    var count = 0

    fun dfs(root: TreeNode?, max: Int) {

        if (root == null) return

        if (root.`val` >= max) count++

        dfs(root.left, max(max, root.`val`))
        dfs(root.right, max(max, root.`val`))
    }

    dfs(root, Int.MIN_VALUE)

    return count
}