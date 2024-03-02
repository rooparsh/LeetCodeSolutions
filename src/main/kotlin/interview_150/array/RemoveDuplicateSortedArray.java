package interview_150.array;

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */

public class RemoveDuplicateSortedArray {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
