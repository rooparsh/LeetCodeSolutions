package two_weeks_study_plan.data_structure_2.day_14

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/find-the-winner-of-the-circular-game/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    print(FindTheWinner().findTheWinner(5, 2))
}

class FindTheWinner {
    fun findTheWinner(n: Int, k: Int): Int {
        var res = 0
        for (i in 1..n) {
            res = (res + k) % i
        }
        return res + 1
    }
}