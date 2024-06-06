package org.example.leetcode.leetcode75.DP_multidimensional;

//1143. Longest Common Subsequence
//Solved
//Medium
//Topics
//Companies
//Hint
//Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
//
//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
//For example, "ace" is a subsequence of "abcde".
//A common subsequence of two strings is a subsequence that is common to both strings.
//
//
//
//Example 1:
//
//Input: text1 = "abcde", text2 = "ace"
//Output: 3
//Explanation: The longest common subsequence is "ace" and its length is 3.
//Example 2:
//
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.
//Example 3:
//
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.
//
//
//Constraints:
//
//1 <= text1.length, text2.length <= 1000
//text1 and text2 consist of only lowercase English characters.
public class _02_LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Create a 2D array to store the lengths of longest common subsequences
        int[][] dp = new int[m + 1][n + 1];

        // Calculate the lengths of longest common subsequences
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // If characters match, increment the length of LCS
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum of LCS lengths from the previous cells
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Return the length of the longest common subsequence
        return dp[m][n];
    }

    public static void main(String[] args) {
        _02_LongestCommonSubsequence solution = new _02_LongestCommonSubsequence();

        String text1_1 = "abcde", text2_1 = "ace";
        System.out.println(solution.longestCommonSubsequence(text1_1, text2_1)); // Output: 3

        String text1_2 = "abc", text2_2 = "abc";
        System.out.println(solution.longestCommonSubsequence(text1_2, text2_2)); // Output: 3

        String text1_3 = "abc", text2_3 = "def";
        System.out.println(solution.longestCommonSubsequence(text1_3, text2_3)); // Output: 0
    }
}

