package interview_150.two_pointer;

/**
 * Difficulty : Easy
 * Problem Statement : https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            char charStart = s.charAt(start);
            char charEnd = s.charAt(end);

            if (!Character.isLetterOrDigit(charStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(charEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(charStart) != Character.toLowerCase(charEnd)) {
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }
}
