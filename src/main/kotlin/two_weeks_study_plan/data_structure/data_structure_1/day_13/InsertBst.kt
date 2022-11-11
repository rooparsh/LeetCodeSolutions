package two_weeks_study_plan.data_structure.data_structure_1.day_13

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/insert-into-a-binary-search-tree/?envType=study-plan&id=data-structure-i
 */
class InsertBst {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        root ?: return TreeNode(`val`)

        if (`val` < root.`val`) {
            if (root.left == null) {
                root.left = TreeNode(`val`)
            } else {
                insertIntoBST(root.left, `val`)
            }
        } else {
            if (root.right == null) {
                root.right = TreeNode(`val`)
            } else {
                insertIntoBST(root.right, `val`)
            }
        }
        return root
    }

    fun insertIntoBST2(root: TreeNode?, `val`: Int): TreeNode? {
        root ?: return TreeNode(`val`)

        when {
            root.`val` < `val` -> root.right = insertIntoBST(root.right, `val`)
            root.`val` > `val` -> root.left = insertIntoBST(root.left, `val`)
        }

        return root
    }
}