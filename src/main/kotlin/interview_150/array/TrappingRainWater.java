package interview_150.array;

/**
 * Difficulty : Hard
 * Problem Statement : https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
 */


public class TrappingRainWater {
    public int trap(int[] height) {

        int size = height.length;
        int[] left = new int[size];
        int[] right = new int[size];
        int trappedWater = 0;

        left[0] = height[0];
        for (int i = 1; i < size; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }


        for (int i = 0; i < size; i++) {
            int minWater = Math.min(left[i], right[i]);
            trappedWater += minWater - height[i];
        }

        return trappedWater;

    }
}
