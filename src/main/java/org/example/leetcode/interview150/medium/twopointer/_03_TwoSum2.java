package org.example.leetcode.interview150.medium.twopointer;

import java.util.Arrays;

//167. Two Sum II - Input Array Is Sorted
//Medium
//Topics
//Companies
//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//
//The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//Your solution must use only constant extra space.
//
//
//
//Example 1:
//
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
//Example 2:
//
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
//Example 3:
//
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
//
//
//Constraints:
//
//2 <= numbers.length <= 3 * 104
//-1000 <= numbers[i] <= 1000
//numbers is sorted in non-decreasing order.
//-1000 <= target <= 1000
//The tests are generated such that there is exactly one solution.
public class _03_TwoSum2 {
    public static void main(String[] args) {

        // Test Cases
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Output for numbers1: " + Arrays.toString(twoSum(numbers1, target1)));

        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        System.out.println("Output for numbers2: " + Arrays.toString(twoSum(numbers2, target2)));

        int[] numbers3 = {-1, 0};
        int target3 = -1;
        System.out.println("Output for numbers3: " + Arrays.toString(twoSum(numbers3, target3)));
    }

    // TC : O(n)
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        // Iterate until left pointer is less than right pointer
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            // If sum equals target, return indices of the two numbers
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Adding 1 to indices as they are 1-indexed
            } else if (sum < target) {
                // If sum is less than target, move left pointer to the right
                left++;
            } else {
                // If sum is greater than target, move right pointer to the left
                right--;
            }
        }

        // If no such pair found, return an empty array
        return new int[]{};
    }

}
