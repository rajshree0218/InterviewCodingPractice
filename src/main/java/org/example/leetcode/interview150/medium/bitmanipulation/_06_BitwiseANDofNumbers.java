package org.example.leetcode.interview150.medium.bitmanipulation;

//201. Bitwise AND of Numbers Range
//Medium
//Topics
//Companies
//Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
//
//
//
//Example 1:
//
//Input: left = 5, right = 7
//Output: 4
//Example 2:
//
//Input: left = 0, right = 0
//Output: 0
//Example 3:
//
//Input: left = 1, right = 2147483647
//Output: 0
//
//
//Constraints:
//
//0 <= left <= right <= 231 - 1
public class _06_BitwiseANDofNumbers {
    public int rangeBitwiseAnd(int left, int right) {
        int shifts = 0;
        // Find the common prefix of left and right by right-shifting both until they are equal
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shifts++;
        }
        // Left-shift the common prefix by the number of shifts to get the result
        return left << shifts;
    }

    public static void main(String[] args) {
        _06_BitwiseANDofNumbers solution = new _06_BitwiseANDofNumbers();

        int left1 = 5, right1 = 7;
        System.out.println("Input: left = " + left1 + ", right = " + right1);
        System.out.println("Output: " + solution.rangeBitwiseAnd(left1, right1));

        int left2 = 0, right2 = 0;
        System.out.println("\nInput: left = " + left2 + ", right = " + right2);
        System.out.println("Output: " + solution.rangeBitwiseAnd(left2, right2));

        int left3 = 1, right3 = 2147483647;
        System.out.println("\nInput: left = " + left3 + ", right = " + right3);
        System.out.println("Output: " + solution.rangeBitwiseAnd(left3, right3));
    }
}
