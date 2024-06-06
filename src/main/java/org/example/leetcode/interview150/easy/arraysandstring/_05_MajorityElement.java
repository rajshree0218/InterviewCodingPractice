package org.example.leetcode.interview150.easy.arraysandstring;

//169. Majority Element
//Easy
//Topics : Array   Hash Table   Divide and Conquer    Sorting   Counting
//Companies

//Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.
//Example 1:
//
//Input: nums = [3,2,3]
//Output: 3
//Example 2:
//
//Input: nums = [2,2,1,1,1,2,2]
//Output: 2
//
//
//Constraints:
//
//n == nums.length
//1 <= n <= 5 * 104
//-109 <= nums[i] <= 109
//
//
//Follow-up: Could you solve the problem in linear time and in O(1) space?
public class _05_MajorityElement {
//    You can solve this problem using Moore's Voting Algorithm, which is an efficient linear time and constant space solution.
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println("Majority Element: " + majorityElement(nums1));

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + majorityElement(nums2));
    }
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int current = 0;
        for(int i=0; i<n;i++){
            if(count==0){
                current = nums[i];
            }
            count += current==nums[i] ? 1:-1;
        }
        return current;
    }
}

