package org.example.leetcode.leetcode75.TwoPointer;

import java.util.Arrays;

//283. Move Zeroes
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Note that you must do this in-place without making a copy of the array.
//
//
//
//Example 1:
//
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
//Example 2:
//
//Input: nums = [0]
//Output: [0]
//
//
//Constraints:
//
//1 <= nums.length <= 10^4
//-231 <= nums[i] <= 231 - 1
//
//
//Follow up: Could you minimize the total number of operations done?
public class _01_MoveZeros {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0; // Pointer to keep track of the position to place the next non-zero element

        // Iterate through the array
        for (int right = 0; right < n; right++) {
            // If the current element is non-zero, move it to the left pointer position
            if (nums[right] != 0) {
                nums[left] = nums[right];
                // If left and right pointers are not at the same position, mark the current position as zero
                if (left != right) {
                    nums[right] = 0;
                }
                left++; // Move the left pointer to the next position
            }
        }
    }

    public static void main(String[] args) {
        _01_MoveZeros solution = new _01_MoveZeros();

        // Example 1
        int[] nums1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1)); // Output: [1, 3, 12, 0, 0]

        // Example 2
        int[] nums2 = {0};
        solution.moveZeroes(nums2);
        System.out.println(Arrays.toString(nums2)); // Output: [0]
    }
}

