package org.example.leetcode.leetcode75.hashmapOrSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//1657. Determine if Two Strings Are Close
//Solved
//Medium
//Topics
//Companies
//Hint
//Two strings are considered close if you can attain one from the other using the following operations:
//
//Operation 1: Swap any two existing characters.
//For example, abcde -> aecdb
//Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
//For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
//You can use the operations on either string as many times as necessary.
//
//Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
//
//
//
//Example 1:
//
//Input: word1 = "abc", word2 = "bca"
//Output: true
//Explanation: You can attain word2 from word1 in 2 operations.
//Apply Operation 1: "abc" -> "acb"
//Apply Operation 1: "acb" -> "bca"
//Example 2:
//
//Input: word1 = "a", word2 = "aa"
//Output: false
//Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
//Example 3:
//
//Input: word1 = "cabbba", word2 = "abbccc"
//Output: true
//Explanation: You can attain word2 from word1 in 3 operations.
//Apply Operation 1: "cabbba" -> "caabbb"
//Apply Operation 2: "caabbb" -> "baaccc"
//Apply Operation 2: "baaccc" -> "abbccc"
//
//
//Constraints:
//
//1 <= word1.length, word2.length <= 10^5
//word1 and word2 contain only lowercase English letters.
public class _03_DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        // Count frequencies and collect characters in word1
        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
            set1.add(ch);
        }

        // Count frequencies and collect characters in word2
        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
            set2.add(ch);
        }

        // Sort frequency arrays and check if sets of characters are the same
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2) && set1.equals(set2);
    }

    public static void main(String[] args) {
        _03_DetermineIfTwoStringsAreClose solution = new _03_DetermineIfTwoStringsAreClose();

        String word1 = "abc";
        String word2 = "bca";
        System.out.println(solution.closeStrings(word1, word2)); // Output: true

        word1 = "a";
        word2 = "aa";
        System.out.println(solution.closeStrings(word1, word2)); // Output: false

        word1 = "cabbba";
        word2 = "abbccc";
        System.out.println(solution.closeStrings(word1, word2)); // Output: true

        word1 = "uau";
        word2 = "ssx";
        System.out.println(solution.closeStrings(word1, word2)); // Output: false

        word1 = "aaabbbbccddeeeeefffff";
        word2 = "aaaaabbcccdddeeeeffff";
        System.out.println(solution.closeStrings(word1, word2)); // Output: false
    }
}
