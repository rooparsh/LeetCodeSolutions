package util

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

data class Point(val x: Int, val y: Int)


val directions: List<Point> = listOf(
    Point(-1, 0),
    Point(1, 0),
    Point(0, -1),
    Point(0, 1)
)