package random


fun main() {
    val map = mutableMapOf<String, Float>().apply {
        put("GBPRUB", 10f)
        put("USDGBP", 100f)
        put("RUBUSD", 9f)
    }
    println(findRates("USDRUB", map))
}

data class ConversionRates(val from: String, val to: String, val rate: Float)

fun findRates(from: String, rates: Map<String, Float>): Pair<Float, String> {

    if (rates[from] != null) {
        return Pair(rates[from]!!, from)
    }


    val map = rates.map {
        val list = it.key.chunked(3)
        ConversionRates(list[0], list[1], it.value)
    }

    val input = from.chunked(3)



    return Pair(0f, "")

}