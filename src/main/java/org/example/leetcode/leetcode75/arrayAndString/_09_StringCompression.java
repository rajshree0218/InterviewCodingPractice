package org.example.leetcode.leetcode75.arrayAndString;

import java.util.Arrays;

//443. String Compression
//Solved
//Medium
//Topics
//Companies
//Hint
//Given an array of characters chars, compress it using the following algorithm:
//
//Begin with an empty string s. For each group of consecutive repeating characters in chars:
//
//If the group's length is 1, append the character to s.
//Otherwise, append the character followed by the group's length.
//The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
//
//After you are done modifying the input array, return the new length of the array.
//
//You must write an algorithm that uses only constant extra space.
//
//
//
//Example 1:
//
//Input: chars = ["a","a","b","b","c","c","c"]
//Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
//Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
//Example 2:
//
//Input: chars = ["a"]
//Output: Return 1, and the first character of the input array should be: ["a"]
//Explanation: The only group is "a", which remains uncompressed since it's a single character.
//Example 3:
//
//Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
//Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
//Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
//
//
//Constraints:
//
//1 <= chars.length <= 2000
//chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
public class _09_StringCompression {

    public int compress2(char[] chars) {
        int n = chars.length;
        int compressedIndex = 0;
        int count = 1;

        for (int i = 1; i <= n; i++) {
            if (i < n && chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[compressedIndex++] = chars[i - 1];
                if (count > 1) {
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[compressedIndex++] = c;
                    }
                }
                count = 1;
            }
        }

        return compressedIndex;
    }

    public int compress(char[] chars) {
        int writeIndex = 0;
        int readIndex = 0;

        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 0;

            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }

            chars[writeIndex++] = currentChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[writeIndex++] = c;
                }
            }
        }

        return writeIndex;
    }

    public static void main(String[] args) {
        _09_StringCompression solution = new _09_StringCompression();

        // Example 1
        char[] chars1 = {'a','a','b','b','c','c','c'};
        int len1 = solution.compress(chars1);
        System.out.println(len1); // Output: 6
        System.out.println(Arrays.copyOfRange(chars1, 0, len1)); // Output: ["a","2","b","2","c","3"]

        // Example 2
        char[] chars2 = {'a'};
        int len2 = solution.compress(chars2);
        System.out.println(len2); // Output: 1
        System.out.println(Arrays.copyOfRange(chars2, 0, len2)); // Output: ["a"]

        // Example 3
        char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int len3 = solution.compress(chars3);
        System.out.println(len3); // Output: 4
        System.out.println(Arrays.copyOfRange(chars3, 0, len3)); // Output: ["a","b","1","2"]
    }
}
