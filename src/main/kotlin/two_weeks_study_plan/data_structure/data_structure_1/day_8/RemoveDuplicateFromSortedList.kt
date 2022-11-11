package two_weeks_study_plan.data_structure.data_structure_1.day_8

import util.ListNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/remove-duplicates-from-sorted-list/?envType=study-plan&id=data-structure-i
 */
fun main() {
    val listNode2 = ListNode(2)
    val listNode1Duplicate = ListNode(1).apply { next = listNode2 }
    val listNode1 = ListNode(1).apply { next = listNode1Duplicate }


    print(RemoveDuplicateFromSortedList().deleteDuplicates(listNode1)?.`val`)
}

class RemoveDuplicateFromSortedList {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        head ?: return null
        val curr = head.`val`
        val nextNode = head.next

        if (curr == nextNode?.`val`) {
            head.next = nextNode.next
            deleteDuplicates(head)
        } else {
            deleteDuplicates(nextNode)
        }
        return head
    }
}