package daily_challenge

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/rectangle-area/
 */

fun main() {
    println(RectangleArea().computeArea(-3, 0, 3, 4, 0, -1, 9, 2))
}

class RectangleArea {

    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        val area1 = Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1)
        val area2 = Math.abs(bx2 - bx1) * Math.abs(by2 - by1)


        // find overlapping area, if any
        val top = Math.min(ay2, by2)
        val bottom = Math.max(ay1, by1)
        val left = Math.max(ax1, bx1)
        val right = Math.min(ax2, bx2)

        var intersectArea = 0

        if (left < right && bottom < top) {
            intersectArea = (top - bottom) * (right - left)
        }

        return area1 + area2 - intersectArea
    }
}