package org.example.leetcode.leetcode75.slidingWindow;

//1493. Longest Subarray of 1's After Deleting One Element
//Solved
//Medium
//Topics
//Companies
//Hint
//Given a binary array nums, you should delete one element from it.
//
//Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
//
//
//
//Example 1:
//
//Input: nums = [1,1,0,1]
//Output: 3
//Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
//Example 2:
//
//Input: nums = [0,1,1,1,0,1,1,0,1]
//Output: 5
//Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
//Example 3:
//
//Input: nums = [1,1,1]
//Output: 2
//Explanation: You must delete one element.
//
//
//Constraints:
//
//1 <= nums.length <= 10^5
//nums[i] is either 0 or 1.
public class _04_LongestSubarrayOf1sAfterDeletingOneElement {

    // not working for example 2
    public int longestSubarray2(int[] nums) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left);

            right++;
        }

        // If the maxLen is equal to the length of the input array - 1,
        // it means that all elements except one are 1, so return maxLen.
        return maxLen == nums.length - 1 ? maxLen : maxLen + 1;
    }

    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int maxLen = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left);
            right++;
        }

        if (zeroCount == 0) {
            return nums.length - 1;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        _04_LongestSubarrayOf1sAfterDeletingOneElement solution = new _04_LongestSubarrayOf1sAfterDeletingOneElement();

        // Example 1
        int[] nums1 = {1, 1, 0, 1};
        System.out.println(solution.longestSubarray(nums1)); // Output: 3

        // Example 2
        int[] nums2 = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(solution.longestSubarray(nums2)); // Output: 5

        // Example 3
        int[] nums3 = {1, 1, 1};
        System.out.println(solution.longestSubarray(nums3)); // Output: 2
    }
}

