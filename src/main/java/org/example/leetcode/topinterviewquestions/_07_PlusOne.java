package org.example.leetcode.topinterviewquestions;

import java.util.Arrays;

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
public class _07_PlusOne {
    public static void main(String[] args) {
        int[] digits1 = {1,2,3};
        int[] output1 = {1,2,4};

        int[] digits2 = {4,3,2,1};
        int[] output2 = {4,3,2,2};

        int[] digits3 = {9};
        int[] output3 = {1,0};

        System.out.println("Result: " + Arrays.toString(plusOne(digits1))); // Output: [1, 2, 4]
        System.out.println("Result: " + Arrays.toString(plusOne(digits2))); // Output: [4, 3, 2, 2]
        System.out.println("Result: " + Arrays.toString(plusOne(digits3))); // Output: [1, 0]
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse the array from the end
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If all digits are 9, we need an extra digit at the beginning
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static int[] plusOne2(int[] digits) {
        int n = digits.length;
        int carry = 1; // Initial carry is the 1 we need to add

        // Process each digit starting from the least significant one
        for (int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;

            // If no carry left, we can return early
            if (carry == 0) {
                return digits;
            }
        }

        // If carry is still 1, we need to add a new most significant digit
        if (carry == 1) {
            int[] newDigits = new int[n + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, n);
            return newDigits;
        }

        return digits;
    }
}
