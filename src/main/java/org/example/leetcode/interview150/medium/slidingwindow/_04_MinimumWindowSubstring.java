package org.example.leetcode.interview150.medium.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//76. Minimum Window Substring
//Hard
//Topics
//Companies
//Hint
//Given two strings s and t of lengths m and n respectively, return the minimum window
//substring
// of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
//
//The testcases will be generated such that the answer is unique.
//
//
//
//Example 1:
//
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
//Example 2:
//
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
//Example 3:
//
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
//
//
//Constraints:
//
//m == s.length
//n == t.length
//1 <= m, n <= 105
//s and t consist of uppercase and lowercase English letters.
//
//
//Follow up: Could you find an algorithm that runs in O(m + n) time?
public class _04_MinimumWindowSubstring {
    public static void main(String[] args) {

    }

    //Time Complexity: O(m + n), where m is the length of string s and n is the length of string t. Both the left and right pointers traverse the string s once, and each character is processed only once.
    //
    //Space Complexity: O(n), where n is the number of distinct characters in string t. The space is used to store the character frequency in the hashmap tMap.
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;
        int stringLength = s.length();

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> windowWordCountMap = new HashMap<>();
            int left = i;
            int right = i;
            while (right + wordLength <= stringLength) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                if (wordCountMap.containsKey(word)) {
                    windowWordCountMap.put(word, windowWordCountMap.getOrDefault(word, 0) + 1);
                    while (windowWordCountMap.get(word) > wordCountMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        windowWordCountMap.put(leftWord, windowWordCountMap.get(leftWord) - 1);
                        left += wordLength;
                    }
                    if (right - left == totalWordsLength) {
                        result.add(left);
                    }
                } else {
                    windowWordCountMap.clear();
                    left = right;
                }
            }
        }

        return result;
    }
}
