package interview_150.array;

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reach < i) {
                return false;
            }
            reach = Math.max(reach, i + nums[i]);
        }

        return true;
    }
}
