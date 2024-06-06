package org.example.leetcode.leetcode75.TwoPointer;

import java.util.HashMap;
import java.util.Map;

//1679. Max Number of K-Sum Pairs
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given an integer array nums and an integer k.
//
//In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
//
//Return the maximum number of operations you can perform on the array.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4], k = 5
//Output: 2
//Explanation: Starting with nums = [1,2,3,4]:
//- Remove numbers 1 and 4, then nums = [2,3]
//- Remove numbers 2 and 3, then nums = []
//There are no more pairs that sum up to 5, hence a total of 2 operations.
//Example 2:
//
//Input: nums = [3,1,3,4,3], k = 6
//Output: 1
//Explanation: Starting with nums = [3,1,3,4,3]:
//- Remove the first two 3's, then nums = [1,4,3]
//There are no more pairs that sum up to 6, hence a total of 1 operation.
//
//
//Constraints:
//
//1 <= nums.length <= 10^5
//1 <= nums[i] <= 10^9
//1 <= k <= 10^9
public class _04_MaxNumOf_K_SumPairs {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int complement = k - num;
            if (frequencyMap.getOrDefault(complement, 0) > 0) {
                count++;
                frequencyMap.put(complement, frequencyMap.get(complement) - 1);
            } else {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        _04_MaxNumOf_K_SumPairs solution = new _04_MaxNumOf_K_SumPairs();

        // Example 1
        int[] nums1 = {1, 2, 3, 4};
        int k1 = 5;
        System.out.println(solution.maxOperations(nums1, k1)); // Output: 2

        // Example 2
        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;
        System.out.println(solution.maxOperations(nums2, k2)); // Output: 1
    }
}
