package two_weeks_study_plan.data_structure_2.day_17

import util.TreeNode


/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/binary-search-tree-iterator/?envType=study-plan&id=data-structure-ii
 */

fun main() {

    val level1Left = TreeNode(1)
    val level1Right = TreeNode(3)
    val root = TreeNode(2).apply {
        left = null
        right = null
    }

    val obj = BinarySearchTreeIterator(root)
    val param_1 = obj.next()
    val param_2 = obj.hasNext()

    println(param_1)
    println(param_2)
}

class BinarySearchTreeIterator(root: TreeNode?) {
    private val nodes = root?.let { traverseNodes(it) } ?: emptyList()
    private val nodeIterator = nodes.iterator()

    fun next(): Int {
        return nodeIterator.next()
    }

    fun hasNext(): Boolean {
        return nodeIterator.hasNext()
    }

    private fun traverseNodes(node: TreeNode): List<Int> {
        val leftNodes = node.left?.let { traverseNodes(it) } ?: emptyList()
        val rightNodes = node.right?.let { traverseNodes(it) } ?: emptyList()
        return leftNodes + node.`val` + rightNodes
    }
}
