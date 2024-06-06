package org.example.leetcode.topinterviewquestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
public class _05_SingleNumber {

    public static void main(String[] args) {
        int[] nums1 = {2,2,1};
        int output1 = 1;

        int[] nums2 = {4,1,2,1,2};
        int output2 = 4;

        int[] nums3 = {1};
        int output3 = 1;

        int k1 = singleNumber(nums1);
        int k2 = singleNumber(nums2);
        int k3 = singleNumber(nums3);

        if(k1==output1 && k2==output2 && k3==output3)
            System.out.println("All test cases are passed");
        else    System.out.println("There are test failure");
    }

    //Explanation:
    //XOR Operation:
    //result ^= num applies the XOR operation between result and num.
    //Since XORing two identical numbers results in 0 and XORing any number with 0 results in the number itself, all duplicate numbers in the array will cancel out, leaving only the single number.
    //Iterating through the array:
    //We iterate through each number in the array and apply the XOR operation.
    //After iterating through all numbers, the result will hold the single number that does not have a duplicate.
    //Examples:
    //For the input nums = {2, 2, 1}, the operations would be:
    //
    //result = 0 ^ 2 = 2
    //result = 2 ^ 2 = 0
    //result = 0 ^ 1 = 1
    //Final result is 1.
    //For the input nums = {4, 1, 2, 1, 2}, the operations would be:
    //
    //result = 0 ^ 4 = 4
    //result = 4 ^ 1 = 5
    //result = 5 ^ 2 = 7
    //result = 7 ^ 1 = 6
    //result = 6 ^ 2 = 4
    //Final result is 4.
    //This approach ensures a time complexity of O(n) and a space complexity of O(1), meeting the problem's constraints effectively.
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result;
    }

    //For the input nums = {4, 1, 2, 1, 2}:
    //
    //Unique elements are {4, 1, 2}. Their sum is 4 + 1 + 2 = 7.
    //Sum of all elements in the array is 4 + 1 + 2 + 1 + 2 = 10.
    //Using the formula: 2 * 7 - 10 = 14 - 10 = 4.
    public static int singleNumber2(int[] nums){
        Set<Integer> uniqueElements = new HashSet<>();
        int sumOfUniqueElements = 0;
        int sumOfAllElements = 0;

        for (int num : nums) {
            if (!uniqueElements.contains(num)) {
                uniqueElements.add(num);
                sumOfUniqueElements += num;
            }
            sumOfAllElements += num;
        }

        // The single number is twice the sum of unique elements minus the sum of all elements
        return 2 * sumOfUniqueElements - sumOfAllElements;
    }

    //
    public static int singleNumber3(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the element with frequency 1
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // This line should never be reached, given the problem constraints
        throw new IllegalArgumentException("No unique element found");
    }

    public static int singleNumber4(int[] nums) {

        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length-1; j++){
                if(nums[j]> nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }
        }
        return -1;
    }

}
