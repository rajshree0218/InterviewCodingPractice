package org.example.leetcode.interview150.medium.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//30. Substring with Concatenation of All Words
//Hard
//Topics
//Companies
//You are given a string s and an array of strings words. All the strings of words are of the same length.
//
//A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
//
//For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
//Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
//
//
//
//Example 1:
//
//Input: s = "barfoothefoobarman", words = ["foo","bar"]
//
//Output: [0,9]
//
//Explanation:
//
//The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
//The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
//
//Example 2:
//
//Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//
//Output: []
//
//Explanation:
//
//There is no concatenated substring.
//
//Example 3:
//
//Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//
//Output: [6,9,12]
//
//Explanation:
//
//The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
//The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
//The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
//
//
//
//Constraints:
//
//1 <= s.length <= 104
//1 <= words.length <= 5000
//1 <= words[i].length <= 30
//s and words[i] consist of lowercase English letters.
public class _03_SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {

    }

    //Time Complexity: Let n be the length of the string s and m be the total number of characters in the words array. The time complexity of this solution is O(n * m), where n is the length of the string s and m is the total number of characters in the words array. This is because for each starting index, we construct a substring of length equal to the total length of all words combined.
    //
    //Space Complexity: The space complexity of this solution is O(m), where m is the total number of characters in the words array. This is because we use HashMaps to store the word counts, which can have at most m unique keys.
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

    // TC : O(n*m), SC : O(m)
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;
        int stringLength = s.length();

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= stringLength - totalWordsLength; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                String substring = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (wordCount.containsKey(substring)) {
                    seen.put(substring, seen.getOrDefault(substring, 0) + 1);
                    if (seen.get(substring) > wordCount.get(substring)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == words.length) {
                result.add(i);
            }
        }

        return result;
    }
}
