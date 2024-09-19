package ru.msvdev.leetcode.topInterview150.twopointers;

/**
 * 125. Valid Palindrome
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
 * all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include
 * letters and numbers.
 * <p>
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * <p>
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * <p>
 * Example 3:
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 * <p>
 * Constraints:
 * -- 1 <= s.length <= 2 * 105
 * -- s consists only of printable ASCII characters.
 */
public class N125ValidPalindrome {

    public boolean isPalindrome(String s) {
        int letIdx = 0;
        int rightIdx = s.length() - 1;

        while (letIdx < rightIdx) {
            char leftChar = s.charAt(letIdx);
            char rightChar = s.charAt(rightIdx);

            if (Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar)) {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                letIdx++;
                rightIdx--;

            } else {
                if (!Character.isLetterOrDigit(leftChar)) {
                    letIdx++;
                }
                if (!Character.isLetterOrDigit(rightChar)) {
                    rightIdx--;
                }
            }
        }

        return true;
    }
}
