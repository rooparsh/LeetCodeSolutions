package two_weeks_study_plan.data_structure.data_structure_2.day_11

import util.ListNode

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/intersection-of-two-linked-lists/?envType=study-plan&id=data-structure-ii
 */
class NodeIntersection {

    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) return null

        var tempA = headA
        var tempB = headB

        var ans: ListNode? = null

        while (tempA != null) {
            tempA.`val` *= -1
            tempA = tempA.next
        }

        while (tempB != null) {
            if (tempB.`val` < 0) {
                ans = tempB
                break
            }
            tempB = tempB.next
        }

        tempA = headA
        while (tempA != null) {
            tempA.`val` *= -1
            tempA = tempA.next
        }

        return ans
    }
}