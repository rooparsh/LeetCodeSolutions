package two_weeks_study_plan.data_structure_2.day_19

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/keys-and-rooms/?envType=study-plan&id=data-structure-ii
 */

fun main() {
    println(KeysAndRooms().canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf())))
}

class KeysAndRooms {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = mutableSetOf<Int>()
        val n = rooms.size

        fun dfs(room: Int) {
            visited.add(room)
            for (r in rooms[room]) {
                if (visited.contains(r).not()) dfs(r)
            }
        }
        dfs(0)
        return visited.size == n
    }
}