package leetcode_75.level_1.day_8

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/?envType=study-plan&id=level-1
 */
class LowestCommonAncestorNodeInBst {


    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        if (root == null || p == null || q == null) return null

        return if (p.`val` < root.`val` && q.`val` < root.`val`) lowestCommonAncestor(root.left, p, q)
        else if (p.`val` > root.`val` && q.`val` > root.`val`) lowestCommonAncestor(root.right, p, q)
        else root
    }
}