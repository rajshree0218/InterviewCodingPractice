package org.example.leetcode.topinterviewquestions;

//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//
//
//
//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
//
//Constraints:
//
//1 <= s.length <= 2 * 105
//s consists only of printable ASCII characters.
public class _16_ValidPalindrome {

    public static boolean isPalindrome(String s) {
        // Normalize the string
        StringBuilder normalized = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                normalized.append(Character.toLowerCase(c));
            }
        }

        // Use two pointers to check if the normalized string is a palindrome
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";

        System.out.println("Is \"" + s1 + "\" a palindrome? " + isPalindrome(s1)); // Output: true
        System.out.println("Is \"" + s2 + "\" a palindrome? " + isPalindrome(s2)); // Output: false
        System.out.println("Is \"" + s3 + "\" a palindrome? " + isPalindrome(s3)); // Output: true
    }
}
