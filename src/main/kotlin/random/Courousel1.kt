package random




fun main() {
    println(isPalindrome("aacc"))
}


fun isPalindrome(s: String): String {

    val map = s.toList().groupingBy { it }.eachCount().toSortedMap()

    val firstHalf = mutableListOf<Char>()
    val secondHalf = mutableListOf<Char>()

    var oddChar: Char? = null
    var oddCount = 0

    map.forEach { (key, value) ->
        if (value % 2 != 0) {
            oddCount++
            oddChar = key
        }
    }

    if (oddCount > 1 || oddCount == 1 && s.length % 2 == 0){
        return "NO"
    }


    map.forEach { (key,value)->

    }

    return ""
}


