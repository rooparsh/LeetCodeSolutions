package random

fun main() {
    println(currencySorter(arrayOf("USD", "GBP", "EUR")))
}

fun currencySorter(array: Array<String>): List<String> {
    return array.groupingBy { it }.eachCount().toSortedMap().toList().sortedByDescending { it.second }.map { it.first }
}