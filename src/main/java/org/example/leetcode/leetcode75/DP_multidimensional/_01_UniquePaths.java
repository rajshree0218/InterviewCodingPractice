package org.example.leetcode.leetcode75.DP_multidimensional;

//62. Unique Paths
//Solved
//Medium
//Topics
//Companies
//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
//
//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//
//The test cases are generated so that the answer will be less than or equal to 2 * 109.
//
//
//
//Example 1:
//
//
//Input: m = 3, n = 7
//Output: 28
//Example 2:
//
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
//
//
//Constraints:
//
//1 <= m, n <= 100
public class _01_UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize the first row and first column to 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Calculate the number of unique paths for each cell
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the number of unique paths to reach the bottom-right corner
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        _01_UniquePaths solution = new _01_UniquePaths();

        int m1 = 3, n1 = 7;
        System.out.println(solution.uniquePaths(m1, n1)); // Output: 28

        int m2 = 3, n2 = 2;
        System.out.println(solution.uniquePaths(m2, n2)); // Output: 3
    }
}
