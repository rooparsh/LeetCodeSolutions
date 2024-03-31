package interview_150.array;

/**
 * Difficulty : Medium
 * Problem Statement : https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int[] frequency = new int[n + 1];
        for (int i : citations) {
            if (i > n) {
                frequency[n]++;
            } else {
                frequency[i]++;
            }
        }

        int cnt = 0;
        for (int i = n; i >= 0; i--) {
            cnt += frequency[i];

            if (cnt >= i) {
                return i;
            }
        }

        return 0;

    }
}
