package random

import util.ListNode

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/merge-k-sorted-lists/
 */

class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        return if (lists.isEmpty()) null
        else if (lists.size == 1) lists[0]
        else lists.reduce { acc, listNode -> mergeTwoLists(acc, listNode) }
    }

    private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1

        val linkedList = ListNode(0)

        if (list1.`val` < list2.`val`) {
            linkedList.`val` = list1.`val`
            linkedList.next = mergeTwoLists(list1.next, list2)
        } else {
            linkedList.`val` = list2.`val`
            linkedList.next = mergeTwoLists(list1, list2.next)
        }

        return linkedList
    }
}