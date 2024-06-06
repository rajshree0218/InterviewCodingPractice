package org.example.leetcode.interview150.medium.math;

//172. Factorial Trailing Zeroes
//Medium
//Topics
//Companies
//Given an integer n, return the number of trailing zeroes in n!.
//
//Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
//
//
//
//Example 1:
//
//Input: n = 3
//Output: 0
//Explanation: 3! = 6, no trailing zero.
//Example 2:
//
//Input: n = 5
//Output: 1
//Explanation: 5! = 120, one trailing zero.
//Example 3:
//
//Input: n = 0
//Output: 0
//
//
//Constraints:
//
//0 <= n <= 104
//
//
//Follow up: Could you write a solution that works in logarithmic time complexity?
public class _03_FactorialTrailingZeroes {
    public static void main(String[] args) {
        int n1=3;
        int output1=0;

        int n2=5;
        int output2=1;

        int n3=0;
        int output3=0;

        System.out.println("Trailing zeroes in 3!: " + trailingZeroes(3));
        System.out.println("Trailing zeroes in 5!: " + trailingZeroes(5));
        System.out.println("Trailing zeroes in 0!: " + trailingZeroes(0));
    }


    public static int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5){
            count += n/5;
            n /= 5;
        }
        return count;
    }
}
