package random

import util.Node
import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */

class NextRightPointer2 {
    fun connect(root: Node?): Node? {
        if (root == null) return null
        val queue: Queue<Node> = LinkedList()

        queue.add(root)

        while (queue.isNotEmpty()) {
            var size = queue.size
            var last: Node? = null

            while (size > 0) {
                val node = queue.poll()
                node.next = last
                last = node
                if (node.right != null) queue.offer(node.right)
                if (node.left != null) queue.offer(node.left)
                size--
            }

        }

        return root
    }
}