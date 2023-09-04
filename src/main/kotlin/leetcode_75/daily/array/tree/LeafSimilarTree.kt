package leetcode_75.daily.array.tree

import util.TreeNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75
 */
fun main() {

}

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    dfs(root1, list1)
    dfs(root2, list2)

    return list1 == list2
}

fun dfs(root: TreeNode?, list: MutableList<Int>) {
    if (root != null) {
        if (root.left == null && root.right == null) {
            list.add(root.`val`)
        }
        dfs(root.left, list)
        dfs(root.right, list)
    }
}
