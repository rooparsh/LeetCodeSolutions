package daily_challenge

import java.util.*

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 */

fun main() {
    println(
        ProfitScheduling().jobScheduling(
            intArrayOf(1, 2, 3, 4, 6),
            intArrayOf(3, 5, 10, 6, 9),
            intArrayOf(20, 20, 100, 70, 60)
        )
    )
}

class ProfitScheduling {

    data class Job(val startTime: Int, val endTime: Int, val profit: Int)

    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val jobs = Array(startTime.size) {
            Job(startTime[it], endTime[it], profit[it])
        }.apply {
            sortBy { it.endTime }
        }

        val profits = TreeMap<Int, Int>().apply {
            jobs.first().let {
                set(it.endTime, it.profit)
            }
        }

        for (i in 1..jobs.lastIndex) {
            val profitBefore = profits.floorEntry(jobs[i].startTime)?.value ?: 0
            profits[jobs[i].endTime] = maxOf(profits.lastEntry()!!.value, jobs[i].profit + profitBefore)
        }

        return profits.lastEntry()!!.value
    }
}