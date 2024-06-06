package org.example.leetcode.leetcode75.DP_1D;

//198. House Robber
//Solved
//Medium
//Topics
//Companies
//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
//Example 2:
//
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.
//
//
//Constraints:
//
//1 <= nums.length <= 100
//0 <= nums[i] <= 400
public class _03_HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // Base case

        // Create an array to store the maximum amount of money that can be robbed up to each house
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Calculate the maximum amount of money that can be robbed up to each house
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        // Return the maximum amount of money that can be robbed tonight
        return dp[n - 1];
    }

    public static void main(String[] args) {
        _03_HouseRobber solution = new _03_HouseRobber();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(solution.rob(nums1)); // Output: 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(solution.rob(nums2)); // Output: 12
    }
}
