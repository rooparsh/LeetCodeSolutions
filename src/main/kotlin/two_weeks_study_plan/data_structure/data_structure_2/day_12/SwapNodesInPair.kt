package two_weeks_study_plan.data_structure.data_structure_2.day_12

import util.ListNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/swap-nodes-in-pairs/?envType=study-plan&id=data-structure-ii
 */

class SwapNodesInPair {

    fun swapPairs2(head: ListNode?): ListNode? {
        head ?: return null
        head.next ?: return head

        if (head.next?.next == null) {
            val x = head.next
            head.next = null
            x?.next = head
            return x
        }

        val x = head.next
        head.next = swapPairs2(head.next?.next)
        x?.next = head
        return x
    }

    fun swapPairs(head: ListNode?): ListNode? {
        head ?: return null

        var ptr = head.next

        ptr ?: return head


        while (ptr?.next != null) {
            val temp = ptr.next

            if (ptr.next?.next != null) {
                ptr.next = ptr.next?.next
                temp?.next = ptr.next?.next
                ptr.next?.next = temp
            }

            ptr = ptr.next?.next
        }

        ptr = head
        val temp: ListNode? = head.next
        ptr.next = temp?.next
        temp?.next = ptr
        return temp
    }
}