package interview_150.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int size = nums.length;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        size = size / 2;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > size) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        return nums[n / 2];
    }
}
