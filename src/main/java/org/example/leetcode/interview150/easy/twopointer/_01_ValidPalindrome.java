package org.example.leetcode.interview150.easy.twopointer;

//125. Valid Palindrome
//Easy
//Topics
//Companies
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
public class _01_ValidPalindrome {
    public static void main(String[] args) {
        // Test cases
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Output for s1: " + isPalindrome(s1));

        String s2 = "race a car";
        System.out.println("Output for s2: " + isPalindrome(s2));

        String s3 = " ";
        System.out.println("Output for s3: " + isPalindrome(s3));
    }


    //Time Complexity (TC): O(n)
    //Space Complexity (SC): O(1)
    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length()-1;

        while(left < right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    //Time Complexity (TC): O(n)
    //Space Complexity (SC): O(n)
    public static boolean isPalindrome3(String s) {
        // Convert the string to lowercase and remove non-alphanumeric characters
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Check if the cleaned string is a palindrome
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
