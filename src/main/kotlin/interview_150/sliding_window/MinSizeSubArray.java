package interview_150.sliding_window;

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinSizeSubArray {

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;

        int currSum = 0;
        int minL = Integer.MAX_VALUE;

        while (r < nums.length) {
            currSum += nums[r];
            while (l <= r && currSum >= target) {
                minL = Math.min(minL, r - l + 1);
                currSum -= nums[l++];
            }
            ++r;
        }

        return minL == Integer.MAX_VALUE ? 0 : minL;
    }
}
