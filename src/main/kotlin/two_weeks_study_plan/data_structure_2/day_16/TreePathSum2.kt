package two_weeks_study_plan.data_structure_2.day_16

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/path-sum-ii/?envType=study-plan&id=data-structure-ii
 */

class TreePathSum2 {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        root ?: return emptyList()

        // return this node if its sum matches the target sum
        if (root.left == null && root.right == null && targetSum == root.`val`) {
            return listOf(listOf(root.`val`))
        }

        // get next target sum for child nodes
        val nextSum = targetSum - root.`val`

        // get paths of child nodes and prepend them with this node so that this node is also on the path
        val leftPaths: List<List<Int>> = pathSum(root.left, nextSum).map { listOf(root.`val`) + it }
        val rightPaths: List<List<Int>> = pathSum(root.right, nextSum).map { listOf(root.`val`) + it }

        return leftPaths + rightPaths
    }
}