package two_weeks_study_plan.data_structure.data_structure_2.day_13

import util.ListNode

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/reverse-nodes-in-k-group/?envType=study-plan&id=data-structure-ii
 */

class ReverseNodesKGroup {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var temp = head

        repeat(k) {
            if (temp == null) return head
            else temp = temp?.next
        }


        val newNextNode = reverseKGroup(temp, k)

        var prev: ListNode? = null
        var curr = head

        repeat(k) {
            val next = curr?.next
            curr?.next = prev
            prev = curr
            curr = next
        }

        head?.next = newNextNode

        return prev
    }
}