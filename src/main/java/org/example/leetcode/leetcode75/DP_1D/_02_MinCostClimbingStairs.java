package org.example.leetcode.leetcode75.DP_1D;

//746. Min Cost Climbing Stairs
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
//
//You can either start from the step with index 0, or the step with index 1.
//
//Return the minimum cost to reach the top of the floor.
//
//
//
//Example 1:
//
//Input: cost = [10,15,20]
//Output: 15
//Explanation: You will start at index 1.
//- Pay 15 and climb two steps to reach the top.
//The total cost is 15.
//Example 2:
//
//Input: cost = [1,100,1,1,1,100,1,1,100,1]
//Output: 6
//Explanation: You will start at index 0.
//- Pay 1 and climb two steps to reach index 2.
//- Pay 1 and climb two steps to reach index 4.
//- Pay 1 and climb two steps to reach index 6.
//- Pay 1 and climb one step to reach index 7.
//- Pay 1 and climb two steps to reach index 9.
//- Pay 1 and climb one step to reach the top.
//The total cost is 6.
//
//
//Constraints:
//
//2 <= cost.length <= 1000
//0 <= cost[i] <= 999
public class _02_MinCostClimbingStairs {

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;

        // Create an array to store the minimum cost to reach each step
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Calculate the minimum cost to reach each step
        for (int i = 2; i < n; i++) {
            // The minimum cost to reach step i is the cost[i] plus the minimum cost to reach step i - 1 or step i - 2
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // Return the minimum cost to reach the top floor
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (i < n ? cost[i] : 0);
        }

        return Math.min(dp[n], dp[n - 1]);
    }

    public static void main(String[] args) {
        _02_MinCostClimbingStairs solution = new _02_MinCostClimbingStairs();

        int[] cost1 = {10, 15, 20};
        System.out.println(solution.minCostClimbingStairs(cost1)); // Output: 15

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(solution.minCostClimbingStairs(cost2)); // Output: 6
    }
}
