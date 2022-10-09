package leetcode_75.level_1.day_6

import java.util.Stack

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/n-ary-tree-preorder-traversal/?envType=study-plan&id=level-1
 */
fun main() {

}

class NaryTreeTraversal {

    fun preOrderRecursion(root: Node?): List<Int> {
        if (root == null) return listOf()
        val result = mutableListOf<Int>(root.`val`)
        for (child in root.children) {
            result.addAll(preorder(child))
        }

        return result
    }

    fun preorder(root: Node?): List<Int> {
        if (root == null) return emptyList<Int>()
        val result = mutableListOf<Int>()

        val stack = Stack<Node>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val n = stack.pop()
            result.add(n.`val`)

            n.children.reversed().forEach { if (it != null) stack.push(it) }

        }
        return result

    }
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}