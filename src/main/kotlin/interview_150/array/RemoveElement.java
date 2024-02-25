package interview_150.array;

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
