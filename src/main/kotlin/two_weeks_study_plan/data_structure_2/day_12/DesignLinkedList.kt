package two_weeks_study_plan.data_structure_2.day_12

import util.ListNode

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/design-linked-list/?envType=study-plan&id=data-structure-ii
 */

class DesignLinkedList {

    private var head: ListNode? = null
    private var length = 0


    private fun getItemAtIndex(index: Int): ListNode? = when {
        length == 0 || index > length -> null
        index <= 0 -> head
        else -> {
            var next = head?.next
            repeat(index - 1) {
                next = next?.next
            }
            next
        }
    }

    fun get(index: Int): Int = getItemAtIndex(index)?.`val` ?: -1

    fun addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }

    fun addAtTail(`val`: Int) {
        addAtIndex(length, `val`)
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index > length) return

        val oldItem = getItemAtIndex(index - 1)
        val newItem = ListNode(`val`)

        when {
            oldItem == null -> head = newItem
            index == 0 -> {
                newItem.next = head
                head = newItem
            }

            else -> {
                newItem.next = oldItem.next
                oldItem.next = newItem
            }
        }
        length++
    }

    fun deleteAtIndex(index: Int) {
        when {
            (length == 0 || index > length - 1 || index < 0) -> return
            index == 0 -> head = head?.next
            else -> {
                getItemAtIndex(index - 1)?.let {
                    it.next = it.next?.next
                }
            }
        }
        length--
    }
}