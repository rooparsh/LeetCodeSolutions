package two_weeks_study_plan.data_structure_1.day_7

import util.ListNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/remove-linked-list-elements/?envType=study-plan&id=data-structure-i
 */
fun main() {
    val listNode4 = ListNode(-4)
    val listNode0 = ListNode(0).apply { next = listNode4 }
    val listNode2 = ListNode(2).apply { next = listNode0 }
    val listNode3 = ListNode(4).apply { next = listNode2 }

    print(RemoveLinkedListElements().removeElements(listNode3, 2)?.`val`)
}

class RemoveLinkedListElements {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) return null

        if (head.`val` == `val`) {
            return removeElements(head.next, `val`)
        }

        head.next = removeElements(head.next, `val`)
        return head
    }
}