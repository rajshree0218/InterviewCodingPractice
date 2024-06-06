package org.example.leetcode.leetcode75.stack;

import java.util.Stack;

//394. Decode String
//Solved
//Medium
//Topics
//Companies
//Given an encoded string, return its decoded string.
//
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
//
//The test cases are generated so that the length of the output will never exceed 105.
//
//
//
//Example 1:
//
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
//Example 2:
//
//Input: s = "3[a2[c]]"
//Output: "accaccacc"
//Example 3:
//
//Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
//
//
//Constraints:
//
//1 <= s.length <= 30
//s consists of lowercase English letters, digits, and square brackets '[]'.
//s is guaranteed to be a valid input.
//All the integers in s are in the range [1, 300].
public class _03_DecodeString {

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                StringBuilder decodedString = currentString;
                currentString = stringStack.pop();
                int repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    currentString.append(decodedString);
                }
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public String decodeString2(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder temp = currentString;
                currentString = stringStack.pop();
                int count = countStack.pop();
                while (count-- > 0) {
                    currentString.append(temp);
                }
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        _03_DecodeString solution = new _03_DecodeString();

        // Example 1
        String s1 = "3[a]2[bc]";
        System.out.println(solution.decodeString(s1)); // Output: "aaabcbc"

        // Example 2
        String s2 = "3[a2[c]]";
        System.out.println(solution.decodeString(s2)); // Output: "accaccacc"

        // Example 3
        String s3 = "2[abc]3[cd]ef";
        System.out.println(solution.decodeString(s3)); // Output: "abcabccdcdcdef"
    }
}
