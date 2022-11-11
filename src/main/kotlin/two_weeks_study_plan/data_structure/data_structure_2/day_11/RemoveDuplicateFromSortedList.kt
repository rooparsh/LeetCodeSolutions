package two_weeks_study_plan.data_structure.data_structure_2.day_11

import util.ListNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/?envType=study-plan&id=data-structure-ii
 */

class RemoveDuplicateFromSortedList {
    fun deleteDuplicates(head: ListNode?, prevNode: ListNode? = null): ListNode? {
        val dummy: ListNode = ListNode(Int.MIN_VALUE).apply { next = head }
        var temp: ListNode? = dummy.next
        var prev: ListNode? = dummy

        while (temp?.next != null) {
            if (temp.`val` == temp.next?.`val`) {
                while (temp!!.next != null && temp.`val` == temp.next!!.`val`) {
                    temp = temp.next
                }
                prev!!.next = temp.next
            } else {
                prev = prev!!.next
            }
            temp = temp.next
        }
        return dummy.next
    }
}