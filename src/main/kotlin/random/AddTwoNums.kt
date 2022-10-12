package random

import util.ListNode


/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/add-two-numbers/
 */
fun main() {

}

class AddTwoNums {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int = 0): ListNode? {
        if (l1 == null && l2 == null && carry == 0) return null
        val s = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + carry
        return ListNode(s % 10).apply { next = addTwoNumbers(l1?.next, l2?.next, s / 10) }
    }
}