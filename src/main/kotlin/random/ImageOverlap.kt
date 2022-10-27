package random

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/image-overlap/
 */
fun main() {
    print(
        ImageOverlap().largestOverlap(
            arrayOf(
                intArrayOf(1, 1, 0), intArrayOf(0, 1, 0), intArrayOf(0, 1, 0)
            ), arrayOf(
                intArrayOf(0, 0, 0), intArrayOf(0, 1, 1), intArrayOf(0, 0, 1)
            )
        )
    )
}

class ImageOverlap {

    private data class Coordinates(val row: Int, val column: Int)

    private fun countOnes(img: Array<IntArray>): Int {
        var numberOfOnes = 0
        img.flatMap { it.toList() }.map { if (it == 1) numberOfOnes++ }
        return numberOfOnes
    }

    private fun findCoordinatesOfOne(img: Array<IntArray>): List<Coordinates> {
        val coordinates = mutableListOf<Coordinates>()

        for (i in img.indices) {
            for (j in img[0].indices) {
                if (img[i][j] == 1) coordinates.add(Coordinates(i, j))
            }
        }

        return coordinates
    }

    private fun countOverlap(
        imageToShift: Array<IntArray>, rowShift: Int, columnShift: Int, coordinateOfOnes: List<Coordinates>
    ): Int {
        var overlap = 0

        for (coordinate in coordinateOfOnes) {
            val isOverlap = with(coordinate) {
                imageToShift.getOrNull(row - rowShift)?.getOrNull(column - columnShift) == 1
            }
            if (isOverlap) overlap++
        }
        return overlap
    }

    fun largestOverlap(img1: Array<IntArray>, img2: Array<IntArray>): Int {
        val onesInImg1 = countOnes(img1)
        val onesInImg2 = countOnes(img2)

        val minOnes = minOf(onesInImg1, onesInImg2)
        if (minOnes == 0 || minOnes == 1) return minOnes

        val (lessContent, moreContent) = if (onesInImg1 < onesInImg2) img1 to img2 else img2 to img1
        val coordinateOfOnes = findCoordinatesOfOne(lessContent)

        val size = img1.size
        val possibleShift = -(size - 1) until size
        var largestOverlap = 0

        for (rowShift in possibleShift) {
            for (columnShift in possibleShift) {
                val overlap = countOverlap(moreContent, rowShift, columnShift, coordinateOfOnes)
                largestOverlap = maxOf(largestOverlap, overlap)

                val reachLargestPossible = largestOverlap == minOnes
                if (reachLargestPossible) return largestOverlap
            }
        }

        return largestOverlap
    }
}