package leetcode_75.level_1.day_3

import util.ListNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/reverse-linked-list/?envType=study-plan&id=level-1
 */

fun main() {

    val listNode4 = ListNode(4)
    val listNode2 = ListNode(2).apply { next = listNode4 }
    val listNode1 = ListNode(1).apply { next = listNode2 }

    println(ReverseLinkedList().reverseList(listNode1)?.`val`)

}


class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null

        return reverse(head)
    }

    private fun reverse(current: ListNode?, prev: ListNode? = null): ListNode? {
        if (current?.next == null) {
            current?.next = prev
            return current
        }

        val n = reverse(current.next, current)
        current.next = prev
        return n
    }
}