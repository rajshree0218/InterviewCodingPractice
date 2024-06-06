package org.example.leetcode.topinterviewquestions;

import java.util.HashMap;
import java.util.Map;

//Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
//
//
//
//Example 1:
//
//Input: s = "leetcode"
//Output: 0
//Example 2:
//
//Input: s = "loveleetcode"
//Output: 2
//Example 3:
//
//Input: s = "aabb"
//Output: -1
//
//
//Constraints:
//
//1 <= s.length <= 105
//s consists of only lowercase English letters.
public class _14_FistUniqueCharInString {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (frequencyMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // If no unique character is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";

        System.out.println("Index of first unique character in \"" + s1 + "\": " + firstUniqChar(s1)); // Output: 0
        System.out.println("Index of first unique character in \"" + s2 + "\": " + firstUniqChar(s2)); // Output: 2
        System.out.println("Index of first unique character in \"" + s3 + "\": " + firstUniqChar(s3)); // Output: -1
    }

}
