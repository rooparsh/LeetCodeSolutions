package two_weeks_study_plan.data_structure_2.day_13

import util.ListNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/reorder-list/?envType=study-plan&id=data-structure-ii
 */

fun main() {

}

class ReOrderList {
    fun reorderList(head: ListNode?): Unit {
        head ?: return
        var temp = head
        temp = recursion(temp)
    }

    private fun recursion(node: ListNode?): ListNode? {

        if (node?.next == null) return node

        var lastNode = node

        var prevNode: ListNode? = null

        while (lastNode!!.next != null) {
            prevNode = lastNode
            lastNode = lastNode.next
        }
        prevNode!!.next = null


        val remainingPart = node.next

        lastNode.next = recursion(remainingPart)

        node.next = lastNode


        return node
    }
}