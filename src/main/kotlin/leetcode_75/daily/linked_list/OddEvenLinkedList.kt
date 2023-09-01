package leetcode_75.daily.linked_list

import util.ListNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/odd-even-linked-list/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    val head = ListNode(4)
    val next = ListNode(2)
    val last = ListNode(9)
    head.next = next
    next.next = last

    oddEvenList(head)
}

fun oddEvenList(head: ListNode?): ListNode? {
    if (head == null)
        return null


    var odd = head
    var even = head.next
    val evenHead = even

    while (even?.next != null) {
        odd?.next = even.next
        odd = odd?.next
        even.next = odd?.next
        even = even.next
    }

    odd?.next = evenHead
    return head
}