package two_weeks_study_plan.algorithm_1

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/first-bad-version/?envType=study-plan&id=algorithm-i
 */

fun main() {
    print(FirstBadVersion().firstBadVersion(5))
}

abstract class VersionControl {
    fun isBadVersion(version: Int): Boolean {
        return version == 4
    }

    abstract fun firstBadVersion(n: Int): Int
}

class FirstBadVersion : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        return find(0, n)
    }

    private fun find(lower: Int, upper: Int): Int {
        val mid = lower + ((upper - lower) / 2)

        val isBad = isBadVersion(mid)

        if (lower >= upper) return upper

        return if (isBad) {
            find(lower, mid)
        } else {
            find(mid + 1, upper)
        }
    }
}