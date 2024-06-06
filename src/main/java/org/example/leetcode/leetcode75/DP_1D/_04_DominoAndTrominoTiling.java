package org.example.leetcode.leetcode75.DP_1D;

//790. Domino and Tromino Tiling
//Attempted
//Medium
//Topics
//Companies
//You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
//
//
//Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large, return it modulo 109 + 7.
//
//In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.
//
//
//
//Example 1:
//
//
//Input: n = 3
//Output: 5
//Explanation: The five different ways are show above.
//Example 2:
//
//Input: n = 1
//Output: 1
//
//
//Constraints:
//
//1 <= n <= 1000
public class _04_DominoAndTrominoTiling {

    public int numTilings2(int n){
         final int MOD = 1000000007;
         int[][] dp = new int[n + 1][3];
         dp[0][0] = 1;
         dp[1][0] = 1;

         for (int i = 2; i <= n; i++) {
             dp[i][0] = (int)(((long)dp[i - 1][0] + dp[i - 2][0] + 2L * dp[i - 1][1] + dp[i - 1][2]) % MOD);
             dp[i][1] = (int)(((long)dp[i - 2][0] + dp[i - 1][2]) % MOD);
             dp[i][2] = (int)(((long)dp[i - 2][0] + dp[i - 1][1]) % MOD);
         }

         return (int)(((long)dp[n][0] + dp[n][1] + dp[n][2]) % MOD);
    }

    public int numTilings(int n) {
        int MOD = 1000000007;

        // Create an array to store the number of ways to tile a 2 x i board
        long[] dp = new long[Math.max(3, n + 1)];

        // Base cases
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        // Calculate the number of ways to tile a 2 x i board
        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }

        // Return the number of ways to tile a 2 x n board
        return (int) dp[n];
    }

    public static void main(String[] args) {
        _04_DominoAndTrominoTiling solution = new _04_DominoAndTrominoTiling();

        int n1 = 3;
        System.out.println(solution.numTilings(n1)); // Output: 5

        int n2 = 1;
        System.out.println(solution.numTilings(n2)); // Output: 1

        int n3 = 4;
        System.out.println(solution.numTilings(n3)); // Output: 11
    }
}
