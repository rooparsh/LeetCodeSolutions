package two_weeks_study_plan.data_structure_2

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan&id=data-structure-ii
 */

class LowestCommonAncestorInBinaryTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        fun dfs(root: TreeNode?): Pair<Int, TreeNode?> {
            if (root == null) return Pair(0, null)
            val left = dfs(root.left)
            if (left.first == 2) return left

            val right = dfs(root.right)
            if (right.first == 2) return right

            val curVal: Int = left.first + right.first + if (root == p || root == q) 1 else 0
            return Pair(curVal, root)
        }

        return dfs(root).second
    }
}