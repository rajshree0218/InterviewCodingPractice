package org.example.leetcode.leetcode75.TwoPointer;

import java.util.*;

//392. Is Subsequence
//Solved
//Easy
//Topics
//Companies
//Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//
//A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
//
//
//
//Example 1:
//
//Input: s = "abc", t = "ahbgdc"
//Output: true
//Example 2:
//
//Input: s = "axc", t = "ahbgdc"
//Output: false
//
//
//Constraints:
//
//0 <= s.length <= 100
//0 <= t.length <= 10^4
//s and t consist only of lowercase English letters.
//
//
//Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
public class _02_IsSubsequence {

    public boolean isSubsequence2(String s, String t) {
        // Build an index of character positions in string t
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            index.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }

        // Initialize pointer to track position in string t
        int pointer = 0;

        // Iterate through characters of s and find their positions in t
        for (char ch : s.toCharArray()) {
            // If the character doesn't exist in t or its position is after the current pointer,
            // s is not a subsequence of t
            if (!index.containsKey(ch)) return false;
            List<Integer> positions = index.get(ch);
            int pos = Collections.binarySearch(positions, pointer);
            if (pos < 0) pos = -pos - 1;
            if (pos == positions.size()) return false; // All positions are after the pointer
            pointer = positions.get(pos) + 1; // Move the pointer to the next position
        }

        return true;
    }

    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;

        while(sIndex < s.length() && tIndex < t.length()){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == s.length();
    }

    public static void main(String[] args) {
        _02_IsSubsequence solution = new _02_IsSubsequence();

        // Example 1
        String s1 = "abc", t1 = "ahbgdc";
        System.out.println(solution.isSubsequence(s1, t1)); // Output: true

        // Example 2
        String s2 = "axc", t2 = "ahbgdc";
        System.out.println(solution.isSubsequence(s2, t2)); // Output: false
    }
}
