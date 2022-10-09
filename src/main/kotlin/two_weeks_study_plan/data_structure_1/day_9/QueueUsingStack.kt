package two_weeks_study_plan.data_structure_1.day_9

import java.util.Stack

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/implement-queue-using-stacks/?envType=study-plan&id=data-structure-i
 */

fun main() {
    val queueUsingStack = QueueUsingStack()
    queueUsingStack.push(5)
    print(queueUsingStack.pop())
    print(queueUsingStack.peek())
    print(queueUsingStack.empty())
}

class QueueUsingStack {
    private val pushStack = Stack<Int>()
    private val popStack = Stack<Int>()

    fun push(x: Int) {
        pushStack.push(x)
    }

    fun pop(): Int {
        peek()
        return popStack.pop()
    }

    fun peek(): Int {
        if (popStack.isEmpty()) {
            while (pushStack.isNotEmpty()) {
                popStack.add(pushStack.pop())
            }
        }
        return popStack.peek()
    }

    fun empty(): Boolean {
        return pushStack.isEmpty() && popStack.isEmpty()
    }
}