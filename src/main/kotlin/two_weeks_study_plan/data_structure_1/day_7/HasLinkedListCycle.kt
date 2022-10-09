package two_weeks_study_plan.data_structure_1.day_7

import two_weeks_study_plan.algorithm_1.day_5.ListNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/linked-list-cycle/?envType=study-plan&id=data-structure-i
 */
fun main() {

    val listNode4 = ListNode(-4)
    val listNode0 = ListNode(0).apply { next = listNode4 }
    val listNode2 = ListNode(2).apply { next = listNode0 }
    val listNode3 = ListNode(4).apply { next = listNode2 }


    listNode4.next = listNode2

    println(HasLinkedListCycle().hasCycle(listNode3))

}

class HasLinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) return false

        var turtle = head
        var hare = head

        while (true) {
            if (hare?.next == null) {
                return false
            }

            turtle = turtle?.next
            hare = hare.next?.next

            if (turtle == hare) {
                return true
            }
        }
    }
}