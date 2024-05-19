package interview_150.two_pointer;

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
 */

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sp = 0;
        int tp = 0;

        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }
        return sp == s.length();
    }
}
