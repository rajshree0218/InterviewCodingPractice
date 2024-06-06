package org.example.leetcode.interview150.easy.math;

import java.util.Arrays;

//66. Plus One
//Easy
//Topics
//Companies
//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//
//Increment the large integer by one and return the resulting array of digits.
//
//
//
//Example 1:
//
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
//Example 2:
//
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].
//Example 3:
//
//Input: digits = [9]
//Output: [1,0]
//Explanation: The array represents the integer 9.
//Incrementing by one gives 9 + 1 = 10.
//Thus, the result should be [1,0].
//
//
//Constraints:
//
//1 <= digits.length <= 100
//0 <= digits[i] <= 9
//digits does not contain any leading 0's.
public class _02_PlusOne {
    public static void main(String[] args) {
        int[] digits1 = {1, 2, 3};
        System.out.println("Result for digits1: " + Arrays.toString(plusOne(digits1)));

        int[] digits2 = {4, 3, 2, 1};
        System.out.println("Result for digits2: " + Arrays.toString(plusOne(digits2)));

        int[] digits3 = {9};
        System.out.println("Result for digits3: " + Arrays.toString(plusOne(digits3)));

    }

    //Time Complexity (TC): O(n)
    //Space Complexity (SC): O(n) (worst case), O(1) (best and average cases)
    public static int[] plusOne(int[] digits) {
        // Iterate through the digits array from right to left
        for (int i = digits.length - 1; i >= 0; i--) {
            // Increment the current digit by one
            digits[i]++;
            // If the digit becomes less than 10 after incrementing, no carry, so return digits
            if (digits[i] < 10) {
                return digits;
            }
            // If the digit becomes 10, set it to 0 and continue to the next digit
            digits[i] = 0;
        }
        // If we're here, it means all digits were 9, so we need to add an additional digit at the beginning
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }


}
