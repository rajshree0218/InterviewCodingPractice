package org.example.leetcode.leetcode75.arrayAndString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//345. Reverse Vowels of a String
//Solved
//Easy
//Topics
//Companies
//Given a string s, reverse only all the vowels in the string and return it.
//
//The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
//
//
//
//Example 1:
//
//Input: s = "hello"
//Output: "holle"
//Example 2:
//
//Input: s = "leetcode"
//Output: "leotcede"
//
//
//Constraints:
//
//1 <= s.length <= 3 * 10^5
//s consist of printable ASCII characters.
public class _05_ReverseVowelOfString {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            if (isVowel(chars[left]) && isVowel(chars[right])) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            } else if (!isVowel(chars[left])) {
                left++;
            } else if (!isVowel(chars[right])) {
                right--;
            }
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public String reverseVowels2(String s) {
        char[] chars = s.toCharArray();

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        _05_ReverseVowelOfString solution = new _05_ReverseVowelOfString();

        // Example 1
        String s1 = "hello";
        System.out.println(solution.reverseVowels(s1)); // Output: "holle"

        // Example 2
        String s2 = "leetcode";
        System.out.println(solution.reverseVowels(s2)); // Output: "leotcede"
    }
}
