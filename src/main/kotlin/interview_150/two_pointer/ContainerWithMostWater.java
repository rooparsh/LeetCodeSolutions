package interview_150.two_pointer;

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            max = Math.max((end - start) * Math.min(height[start], height[end]), max);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
