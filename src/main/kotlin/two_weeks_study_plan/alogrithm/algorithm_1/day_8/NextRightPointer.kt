package two_weeks_study_plan.alogrithm.algorithm_1.day_8

import util.Node

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/?envType=study-plan&id=algorithm-i
 */

class NextRightPointer {
    fun connect(root: Node?): Node? =
        if (root?.left == null && root?.right == null) root
        else root.apply {
            left?.next = right
            right?.next = next?.left
            connect(left)
            connect(right)
        }
}