package leetcode_75.level_1.day_3

import util.ListNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/squares-of-a-sorted-array/?envType=study-plan&id=algorithm-i
 */

fun main() {

    val listNode4 = ListNode(4)
    val listNode2 = ListNode(2).apply { next = listNode4 }
    val listNode1 = ListNode(1).apply { next = listNode2 }


    val listNode4New = ListNode(4)
    val listNode3New = ListNode(2).apply { next = listNode4New }
    val listNode1New = ListNode(1).apply { next = listNode3New }

    println(MergeSortedList().mergeTwoLists(listNode1, listNode1New)?.`val`)

}

class MergeSortedList {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

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