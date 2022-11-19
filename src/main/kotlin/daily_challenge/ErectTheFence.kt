package daily_challenge

import java.util.*

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/erect-the-fence/
 */

fun main() {
    print(
        ErectTheFence().outerTrees(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(2, 0),
                intArrayOf(2, 4),
                intArrayOf(3, 3),
                intArrayOf(4, 2),
            )
        ).joinToString(",")
    )
}

class ErectTheFence {

    private class Trees(private val type: Type) {
        enum class Type(val value: Int) {
            CONVEX(1), CONCAVE(-1)
        }

        private val _trees = mutableListOf<IntArray>()
        val trees: List<IntArray> = _trees

        fun add(tree: IntArray) {
            val needRemoveLast: () -> Boolean = {
                trees.size > 1 && run {
                    val prev = trees[trees.lastIndex]
                    val prevPrev = trees[trees.lastIndex - 1]
                    return@run ((tree[1] - prev[1]) * (prev[0] - prevPrev[0]) -
                            (prev[1] - prevPrev[1]) * (tree[0] - prev[0])) * type.value > 0
                }
            }
            while (needRemoveLast()) {
                _trees.removeAt(trees.lastIndex)
            }
            _trees.add(tree)
        }
    }

    fun outerTrees(trees: Array<IntArray>): Array<IntArray> {
        trees.sortWith(compareBy({ it[0] }, { it[1] }))
        val structuredTrees = trees.groupByTo(TreeMap<Int, MutableList<IntArray>>()) { it[0] }.values

        val upperTrees = Trees(Trees.Type.CONVEX)
        val lowerTrees = Trees(Trees.Type.CONCAVE)

        structuredTrees.forEach {
            upperTrees.add(it.last())
            lowerTrees.add(it.first())
        }

        return mutableSetOf<IntArray>().apply {
            addAll(structuredTrees.first())
            addAll(structuredTrees.last())
            addAll(upperTrees.trees)
            addAll(lowerTrees.trees)
        }.toTypedArray()
    }
}