package two_weeks_study_plan.data_structure_2.day_14

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/min-stack/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    val stack = MinStack()
    stack.push(-1)
    stack.top()
    stack.getMin()
}

class MinStack {
    val array = mutableListOf<Int>()

    fun push(`val`: Int) {
        array.add(0, `val`)
    }

    fun pop() {
        array.removeAt(0)
    }

    fun top(): Int {
        return array[0]
    }

    fun getMin(): Int {
        var smallest = Int.MAX_VALUE

        array.forEach {
            println("$smallest , $it")
            if (it < smallest) smallest = it
        }
        return smallest
    }

}

class MinStack2 {

    private data class Node(val `val`: Int, val min: Int)

    private val linkedList = LinkedList<Node>()

    fun push(`val`: Int) {
        if (linkedList.isEmpty()) {
            linkedList.push(Node(`val`, `val`))
        } else {
            val currentMin = getMin()
            linkedList.push(Node(`val`, Math.min(`val`, currentMin)))
        }
    }

    fun pop() {
        linkedList.pop()
    }

    fun top(): Int {
        return linkedList.first.`val`
    }

    fun getMin(): Int {
        return linkedList.first.min
    }

}