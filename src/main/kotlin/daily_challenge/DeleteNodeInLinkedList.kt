package daily_challenge

import util.ListNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
class DeleteNodeInLinkedList {
    fun deleteNode(node: ListNode?) {
        var currentNode = node
        var prevNode = currentNode

        while (currentNode?.next != null) {
            val temp = currentNode.next
            currentNode.`val` = currentNode.next?.`val` ?: 0
            currentNode.next = currentNode.next
            prevNode = currentNode
            currentNode = temp
        }

        prevNode?.next = null
    }
}