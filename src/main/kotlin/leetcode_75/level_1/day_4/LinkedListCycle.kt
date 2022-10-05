package leetcode_75.level_1.day_4

import two_weeks_study_plan.algorithm_1.day_5.ListNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/linked-list-cycle-ii/?envType=study-plan&id=level-1
 */
fun main() {

    val listNode4 = ListNode(-4)
    val listNode0 = ListNode(0).apply { next = listNode4 }
    val listNode2 = ListNode(2).apply { next = listNode0 }
    val listNode3 = ListNode(4).apply { next = listNode2 }


    listNode4.next = listNode2

    println(LinkedListCycle().detectCycle(listNode3)?.`val`)

}

class LinkedListCycle {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head?.next == null) return null

        var turtle = head
        var hare = head

        while (true) {
            if (hare?.next == null) {
                return null
            }

            turtle = turtle?.next
            hare = hare.next?.next

            if (turtle == hare) {
                break
            }
        }

        var p1 = head
        var p2 = hare
        while (p1 != p2) {
            p1 = p1?.next
            p2 = p2?.next
        }

        return p1
    }
}