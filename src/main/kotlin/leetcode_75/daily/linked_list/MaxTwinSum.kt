package leetcode_75.daily.linked_list

import util.ListNode
import kotlin.math.max

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
 */

fun main() {
    val head = ListNode(4)
    val next = ListNode(2)
    val last = ListNode(9)
    head.next = next
    next.next = last

    pairSum(head)
}

fun pairSum(head: ListNode?): Int {
    var slow = head
    var fast = head?.next

    // Find the middle of the linked list (the prev of the second half)
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    // Reverse the second half
    var prev: ListNode? = null
    var curr = slow?.next

    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    // Build the new linked list in place
    slow?.next = prev

    // Sum up the pairs starting from the head and the half way head
    var ans = 0
    var first = head
    var second = slow?.next // the new head for the second half
    while (second != null) {
        ans = max(ans, first!!.`val` + second.`val`)

        first = first.next
        second = second.next
    }

    return ans
}