package org.example.leetcode.leetcode75.slidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//1456. Maximum Number of Vowels in a Substring of Given Length
//Solved
//Medium
//Topics
//Companies
//Hint
//Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
//
//Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
//
//
//
//Example 1:
//
//Input: s = "abciiidef", k = 3
//Output: 3
//Explanation: The substring "iii" contains 3 vowel letters.
//Example 2:
//
//Input: s = "aeiou", k = 2
//Output: 2
//Explanation: Any substring of length 2 contains 2 vowels.
//Example 3:
//
//Input: s = "leetcode", k = 3
//Output: 2
//Explanation: "lee", "eet" and "ode" contain 2 vowels.
//
//
//Constraints:
//
//1 <= s.length <= 10^5
//s consists of lowercase English letters.
//1 <= k <= s.length
public class _02_MaxNumOfVowelInSubstring {

    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int maxCount = 0;
        int count = 0;

        // Calculate vowels in the first window of length k
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        maxCount = count;

        // Slide the window and update the maxCount
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public int maxVowels2(String s, int k) {
        int n = s.length();
        int[] vowelsCount = new int[n + 1];

        for (int i = 0; i < n; i++) {
            vowelsCount[i + 1] = vowelsCount[i] + (isVowel(s.charAt(i)) ? 1 : 0);
        }

        int maxVowels = 0;

        for (int i = k; i <= n; i++) {
            maxVowels = Math.max(maxVowels, vowelsCount[i] - vowelsCount[i - k]);
        }

        return maxVowels;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        _02_MaxNumOfVowelInSubstring solution = new _02_MaxNumOfVowelInSubstring();

        // Example 1
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.println(solution.maxVowels(s1, k1)); // Output: 3

        // Example 2
        String s2 = "aeiou";
        int k2 = 2;
        System.out.println(solution.maxVowels(s2, k2)); // Output: 2

        // Example 3
        String s3 = "leetcode";
        int k3 = 3;
        System.out.println(solution.maxVowels(s3, k3)); // Output: 2
    }
}

