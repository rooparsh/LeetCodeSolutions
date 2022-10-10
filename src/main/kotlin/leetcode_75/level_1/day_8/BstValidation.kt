package leetcode_75.level_1.day_8

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/validate-binary-search-tree/?envType=study-plan&id=level-1
 */
fun main() {

}

class BstValidation {
    fun isValidBST(root: TreeNode?, minValue: Long = Long.MIN_VALUE, maxValue: Long = Long.MAX_VALUE): Boolean {
        root ?: return true
        if (root.`val` <= minValue || root.`val` >= maxValue) return false

        val leftValid = isValidBST(root.left, minValue, root.`val`.toLong())
        val rightValid = isValidBST(root.right, root.`val`.toLong(), maxValue)
        return leftValid && rightValid
    }
}