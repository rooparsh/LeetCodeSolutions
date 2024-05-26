package interview_150.two_pointer;

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class TwoSumTwo {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int total = numbers[start] + numbers[end];
            if (total == target) {
                return new int[]{start + 1, end + 1};
            } else if (total > target) {
                end--;
            } else {
                start++;
            }
        }

        return new int[]{-1, -1};
    }
}
