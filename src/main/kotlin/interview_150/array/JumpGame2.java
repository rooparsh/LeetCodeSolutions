package interview_150.array;

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
 */

public class JumpGame2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int current = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == current) {
                jumps++;
                current = farthest;
            }
        }

        return jumps;
    }
}
