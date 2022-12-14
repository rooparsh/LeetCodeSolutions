package two_weeks_study_plan.alogrithm.algorithm_1.day_7

import util.Point
import util.directions
import java.util.*


/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/flood-fill/?envType=study-plan&id=algorithm-i
 */

fun main() {
    println(FloodFill().floodFill(arrayOf(intArrayOf(0, 0, 0)), 0, 0, 2))
}

class FloodFill {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val floodFilled: Array<IntArray> = image
        val visitQueue: Queue<Point> = ArrayDeque<Point>()

        visitQueue.add(Point(sr, sc))
        val initialColor = image[sr][sc]

        if (initialColor == color) {
            return floodFilled
        }

        while (!visitQueue.isEmpty()) {
            val curr = visitQueue.poll()
            floodFilled[curr.x][curr.y] = color

            for (direction in directions) {
                if (curr.x + direction.x < floodFilled.size
                    && curr.x + direction.x >= 0
                    && curr.y + direction.y < floodFilled[curr.x].size
                    && curr.y + direction.y >= 0
                    && floodFilled[curr.x + direction.x][curr.y + direction.y] == initialColor
                ) {
                    visitQueue.add(Point(curr.x + direction.x, curr.y + direction.y))
                }
            }
        }
        return floodFilled
    }
}