package two_weeks_study_plan.algorithm_1.day_5

import util.ListNode


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/middle-of-the-linked-list/?envType=study-plan&id=algorithm-i
 */

fun main() {
    val listNode6 = ListNode(6)
    val listNode5 = ListNode(5).apply { next = listNode6 }
    val listNode4 = ListNode(4).apply { next = listNode5 }
    val listNode3 = ListNode(3).apply { next = listNode4 }
    val listNode2 = ListNode(2).apply { next = listNode3 }
    val listNode1 = ListNode(1).apply { next = listNode2 }

    println(MiddleOfLinkedList().middleNode(listNode1)?.`val`)
}

class MiddleOfLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        var node = head
        for (i in 1..lengthOfLinedList(head) / 2) {
            node = node?.next
        }
        return node
    }

    private fun lengthOfLinedList(head: ListNode?): Int {
        var node = head
        var length = 0
        while (node != null) {
            length++
            node = node.next
        }
        return length
    }
}