package two_weeks_study_plan.alogrithm.algorithm_1.day_5

import util.ListNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=study-plan&id=algorithm-i
 */

fun main() {
    val listNode5 = ListNode(5)
    val listNode4 = ListNode(4).apply { next = listNode5 }
    val listNode3 = ListNode(3).apply { next = listNode4 }
    val listNode2 = ListNode(2).apply { next = listNode3 }
    val listNode1 = ListNode(1).apply { next = listNode2 }

    println(RemoveNthNodFromEndOfList().removeNthFromEnd(listNode1, 2)?.`val`)
}

class RemoveNthNodFromEndOfList {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return null

        var nodeCount = 0
        var current = head

        while (current != null) {
            nodeCount++
            current = current.next
        }

        if (nodeCount == n) return head.next

        var prev: ListNode? = null
        current = head
        val dummy = ListNode(-1)
        dummy.next = current

        var step = nodeCount - n
        while (step-- > 0) {
            prev = current
            current = current?.next
        }

        prev?.next = current?.next

        return dummy.next
    }
}