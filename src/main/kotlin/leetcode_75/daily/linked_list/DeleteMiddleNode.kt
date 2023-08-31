package leetcode_75.daily.linked_list

import util.ListNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    val head = ListNode(4)
    val next = ListNode(2)
    val last = ListNode(9)
    head.next = next
    next.next = last

    deleteMiddle(head)
}

fun deleteMiddle(head: ListNode?): ListNode? {
    if (head?.next == null) return null

    var count = 0

    var pointer = head
    var temp = head


    while (pointer != null) {
        count++
        pointer = pointer.next
    }

    val middle = count / 2


    for (i in 0 until middle - 1) {
        temp = temp?.next
    }

    temp?.next = temp?.next?.next

    return head

}