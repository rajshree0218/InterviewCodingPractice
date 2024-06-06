package org.example.leetcode.leetcode75.DP_multidimensional;

//72. Edit Distance
//Solved
//Medium
//Topics
//Companies
//Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//
//You have the following three operations permitted on a word:
//
//Insert a character
//Delete a character
//Replace a character
//
//
//Example 1:
//
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation:
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
//Example 2:
//
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation:
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')
//
//
//Constraints:
//
//0 <= word1.length, word2.length <= 500
//word1 and word2 consist of lowercase English letters.
public class _04_EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a 2D array to store the minimum number of operations
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the first row and column
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Calculate the minimum number of operations
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match, no operation needed
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], // Replace
                            Math.min(dp[i - 1][j], // Delete
                                    dp[i][j - 1])) + 1; // Insert
                }
            }
        }

        // Return the minimum number of operations
        return dp[m][n];
    }

    public static void main(String[] args) {
        _04_EditDistance solution = new _04_EditDistance();

        String word1_1 = "horse", word2_1 = "ros";
        System.out.println(solution.minDistance(word1_1, word2_1)); // Output: 3

        String word1_2 = "intention", word2_2 = "execution";
        System.out.println(solution.minDistance(word1_2, word2_2)); // Output: 5
    }
}


