package daily_challenge

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/delete-columns-to-make-sorted/
 */

fun main() {
    print(DeleteColumnsToMakeSorted().minDeletionSize(arrayOf("cba", "daf", "ghi")))
}

class DeleteColumnsToMakeSorted {
    fun minDeletionSize(strs: Array<String>): Int {
        var count = 0

        val countingArray = CharArray(strs.first().length)

        strs.forEach { str ->
            str.forEachIndexed { j, char ->
                countingArray[j] = when {
                    countingArray[j] == 'A' -> return@forEachIndexed
                    countingArray[j] > char -> {
                        count++
                        'A'
                    }

                    else -> char
                }
            }
        }

        return count
    }
}