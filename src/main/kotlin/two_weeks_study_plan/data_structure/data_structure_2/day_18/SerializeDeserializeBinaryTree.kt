package two_weeks_study_plan.data_structure.data_structure_2.day_18

import util.TreeNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */

class SerializeDeserializeBinaryTree {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        return root?.let { node -> "${node.`val`},${serialize(node.left)},${serialize(root.right)}" } ?: ""
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? = deserialize(data.split(",").toMutableList())

    private fun deserialize(data: MutableList<String>): TreeNode? = data.takeUnless { it.isEmpty() }?.let { strings ->
        strings.removeAt(0).let { first ->
            first.takeUnless { it == "null" }?.let { numStr ->
                TreeNode(numStr.toInt()).apply {
                    this.left = deserialize(strings)
                    this.right = deserialize(strings)
                }
            }
        }
    }

}