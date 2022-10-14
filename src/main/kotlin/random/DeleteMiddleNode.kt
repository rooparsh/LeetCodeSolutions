package random

import util.ListNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */

class DeleteMiddleNode {

    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null)
            return null

        var fast = head
        var slow = head
        var prevSlow: ListNode? = null

        while (fast?.next != null) {
            prevSlow = slow
            slow = slow?.next
            fast = fast.next?.next
        }
        prevSlow?.next = slow?.next

        return head
    }
}