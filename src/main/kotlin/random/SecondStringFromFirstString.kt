package random

/**
 * Difficulty : Medium
 * Problem Statement : https://stackoverflow.com/questions/11461970/check-if-a-string-can-be-made-from-the-characters-in-another-string-in-javascrip
 */
fun main() {
    print(isSecondStringFromFirstString("placx", "plane"))
}


fun isSecondStringFromFirstString(first: String?, second: String?): Boolean {
    if (first.isNullOrEmpty() || second.isNullOrEmpty()) return false

    val firstMap = first.toList().groupingBy { it }.eachCount()
    val secondMap = second.toList().groupingBy { it }.eachCount()


    secondMap.forEach { (key, value) ->
        if (firstMap[key] == null || firstMap[key]!! < value) return false
    }

    return true

}