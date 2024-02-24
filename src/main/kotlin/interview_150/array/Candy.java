package interview_150.array;


import java.util.Arrays;

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class Candy {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int[] candies = new int[size];
        Arrays.fill(candies, 1);

        for (int i = 1; i < size; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = size - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int answer = 0;
        for (int candy : candies) {
            answer += candy;
        }

        return answer;
    }
}
