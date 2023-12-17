package random

import java.util.*

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/design-a-food-rating-system/description/?envType=daily-question&envId=2023-12-17
 */
fun main() {
}

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {

    private val foodToRating = mutableMapOf<String, Int>()
    private val foodToCuisine = foods.mapIndexed { i, food -> food to cuisines[i] }.toMap()
    private val cuisineToHeap = mutableMapOf<String, PriorityQueue<String>>()

    init {
        foods.mapIndexed { i, food -> food to ratings[i] }.toMap(foodToRating)
        val cuisineToFoods =
            cuisines.mapIndexed { i, cuisine -> cuisine to foods[i] }.groupBy({ it.first }, { it.second })
        cuisineToFoods.entries.forEach { entry ->
            val maxHeap = PriorityQueue<String>(compareByDescending<String> { foodToRating[it]!! }.thenBy { it })
            entry.value.forEach {
                maxHeap.add(it)
            }
            cuisineToHeap[entry.key] = maxHeap
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val cuisine = foodToCuisine[food]!!
        cuisineToHeap[cuisine]!!.remove(food)
        foodToRating[food] = newRating
        cuisineToHeap[cuisine]!!.add(food)
    }

    fun highestRated(cuisine: String): String {
        return cuisineToHeap[cuisine]!!.peek()
    }

}

