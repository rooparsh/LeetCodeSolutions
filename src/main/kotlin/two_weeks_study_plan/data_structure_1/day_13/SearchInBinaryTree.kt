package two_weeks_study_plan.data_structure_1.day_13

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/search-in-a-binary-search-tree/?envType=study-plan&id=data-structure-i
 */
class SearchInBinaryTree {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        return if (root == null || root.`val` == `val`) return root
        else if (root.`val` < `val`) searchBST(root.right, `val`)
        else searchBST(root.left, `val`)
    }
}