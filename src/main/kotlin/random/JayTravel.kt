package random


fun main() {
    val string = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n" +
            "Jay.png, London, 2015-06-20 15:13:22\n" +
            "myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
            "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
            "pisatower.jpg, Paris, 2015-07-22 23:59:59\n" +
            "BOB.jpg, London, 2015-08-05 00:02:03\n" +
            "notredame.png, Paris, 2015-09-01 12:00:00\n" +
            "me.jpg, Warsaw, 2013-09-06 15:40:22\n" +
            "a.png, Warsaw, 2016-02-13 13:33:50\n" +
            "b.jpg, Warsaw, 2016-01-02 15:12:22\n" +
            "c.jpg, Warsaw, 2016-01-02 14:34:30\n" +
            "d.jpg, Warsaw, 2016-01-02 15:15:01\n" +
            "e.png, Warsaw, 2016-01-02 09:49:09\n" +
            "f.png, Warsaw, 2016-01-02 10:55:32\n" +
            "g.jpg, Warsaw, 2016-02-29 22:13:11"


    println(solution(string))
}

data class Image(
    val originalName: String,
    val extension: String,
    val location: String,
    val timeStamp: String,
    var newName: String? = null,
    val order: Int
)

fun solution(S: String): String {

    val map = S.split("\n")
        .mapIndexed { index, it ->
            val singlePhoto = it.split(",", ".").map { it.trim() }
            Image(
                originalName = singlePhoto[0],
                extension = singlePhoto[1],
                location = singlePhoto[2],
                timeStamp = singlePhoto[3],
                order = index
            )
        }.groupBy { it.location }

    map.forEach { (_, value) ->
        value.sortedBy { it.timeStamp }
            .mapIndexed { index, it ->
                val number = "${index + 1}".padStart(calculatePadding(value.size), '0')
                it.newName = "${it.location}$number.${it.extension}"
            }
    }

    return map.values.flatten().sortedBy { it.order }.map { it.newName }.joinToString("\n")
}

private fun calculatePadding(count: Int): Int {
    val padding = if (count < 10) {
        1
    } else if (count < 100) {
        2
    } else {
        3
    }
    return padding
}