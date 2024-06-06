package org.example.leetcode.topinterviewquestions;

//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//
//
//Example 1:
//
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
//Example 2:
//
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
//
//
//Constraints:
//
//1 <= haystack.length, needle.length <= 104
//haystack and needle consist of only lowercase English characters.
public class _18_ImplementStrStr {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int hLength = haystack.length();
        int nLength = needle.length();

        // Loop through the haystack
        for (int i = 0; i <= hLength - nLength; i++) {
            // Check if the substring of haystack starting at i matches needle
            int j;
            for (j = 0; j < nLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            // If the whole needle is found in haystack
            if (j == nLength) {
                return i;
            }
        }

        // If needle is not found in haystack
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad")); // Output: 0
        System.out.println(strStr("leetcode", "leeto")); // Output: -1
    }
}
