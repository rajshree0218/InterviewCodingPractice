package org.example.leetcode.interview150.easy.bitmanipulation;

//136. Single Number
//Easy
//Topics
//Companies
//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//
//
//Example 1:
//
//Input: nums = [2,2,1]
//Output: 1
//Example 2:
//
//Input: nums = [4,1,2,1,2]
//Output: 4
//Example 3:
//
//Input: nums = [1]
//Output: 1
//
//
//Constraints:
//
//1 <= nums.length <= 3 * 104
//-3 * 104 <= nums[i] <= 3 * 104
//Each element in the array appears twice except for one element which appears only once.
public class _04_SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation cancels out duplicates, leaving only the single number
        }
        return result;
    }

    public static void main(String[] args) {
        _04_SingleNumber solution = new _04_SingleNumber();

        int[] nums1 = {2, 2, 1};
        System.out.println("Input: nums = [2, 2, 1]");
        System.out.println("Output: " + solution.singleNumber(nums1));

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("\nInput: nums = [4, 1, 2, 1, 2]");
        System.out.println("Output: " + solution.singleNumber(nums2));

        int[] nums3 = {1};
        System.out.println("\nInput: nums = [1]");
        System.out.println("Output: " + solution.singleNumber(nums3));
    }
}
