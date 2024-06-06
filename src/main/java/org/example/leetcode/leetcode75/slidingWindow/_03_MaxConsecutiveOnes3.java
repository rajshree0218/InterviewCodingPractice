package org.example.leetcode.leetcode75.slidingWindow;

//1004. Max Consecutive Ones III
//Solved
//Medium
//Topics
//Companies
//Hint
//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//
//
//
//Example 1:
//
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//Example 2:
//
//Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//Output: 10
//Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//
//
//Constraints:
//
//1 <= nums.length <= 10^5
//nums[i] is either 0 or 1.
//0 <= k <= nums.length
public class _03_MaxConsecutiveOnes3 {
    public int longestOnes2(int[] nums, int k) {
        int maxConsecutiveOnes = 0;
        int left = 0;
        int zerosCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zerosCount++;
            }

            while (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }

            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left + 1);
        }

        return maxConsecutiveOnes;
    }

    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int zeroCount = 0;

        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        _03_MaxConsecutiveOnes3 solution = new _03_MaxConsecutiveOnes3();

        // Example 1
        int[] nums1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        System.out.println(solution.longestOnes(nums1, k1)); // Output: 6

        // Example 2
        int[] nums2 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k2 = 3;
        System.out.println(solution.longestOnes(nums2, k2)); // Output: 10
    }
}
