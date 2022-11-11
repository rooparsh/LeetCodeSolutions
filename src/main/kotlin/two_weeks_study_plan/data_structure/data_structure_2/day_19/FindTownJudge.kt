package two_weeks_study_plan.data_structure.data_structure_2.day_19

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/find-the-town-judge/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    println(FindTownJudge().findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3))))
}

class FindTownJudge {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val array = IntArray(n)
        for (i in trust.indices) {
            array[trust[i][0] - 1]--
            array[trust[i][1] - 1]++
        }
        array.toList()
        return if (array.contains(n - 1)) array.indexOf(n - 1) + 1 else -1
    }
}