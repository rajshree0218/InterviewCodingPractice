package org.example.leetcode.interview150.medium.math;

//50. Pow(x, n)
//Medium
//Topics
//Companies
//Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
//
//
//
//Example 1:
//
//Input: x = 2.00000, n = 10
//Output: 1024.00000
//Example 2:
//
//Input: x = 2.10000, n = 3
//Output: 9.26100
//Example 3:
//
//Input: x = 2.00000, n = -2
//Output: 0.25000
//Explanation: 2-2 = 1/22 = 1/4 = 0.25
//
//
//Constraints:
//
//-100.0 < x < 100.0
//-231 <= n <= 231-1
//n is an integer.
//Either x is not zero or n > 0.
//-104 <= xn <= 104
public class _05_Pow_x_n {
    public static void main(String[] args) {

        //edge TC failed, added edge condition
        double x9 = 2.00000;
        int n9 = -2147483648;
        double output9 = 0.00000;
        System.out.println("Result for x = 2.00000, n = 10: " + myPow(2.00000, 10));
        System.out.println("Result for x = 2.10000, n = 3: " + myPow(2.10000, 3));
        System.out.println("Result for x = 2.00000, n = -2: " + myPow(2.00000, -2));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0; // x^0 = 1
        }

        double result = 1.0;
        long power = ((long) n >= 0) ? (long)n: (long)-n;
        // Handle the edge case when n is the minimum value of a 32-bit signed integer
        if (power == Integer.MIN_VALUE) {
            result *= x;
            power--;
        }

        while (power > 0) {
            if (power % 2 == 1) {
                result *= x;
            }
            x *= x;
            power /= 2;
        }

        if (n < 0) {
            return 1 / result;
        } else {
            return result;
        }
    }

    public static double myPow2(double x, int n) {
        if (n == 0) {
            return 1.0; // x^0 = 1
        }

        double result = 1.0;
        long power = Math.abs((long) n); // Convert n to long to handle overflow
        // same above line can be written as: long power = ((long) n >= 0) ? (long)n: (long)-n;
        //The issue here arises from how we handle n when it's negative. In the given test case, n = -2147483648, which represents the minimum value of a 32-bit signed integer. The problem is that the absolute value of n is out of range for a positive integer.

        while (power > 0) {
            if (power % 2 == 1) {
                result *= x; // If power is odd, multiply result by x
            }
            x *= x; // Square x
            power /= 2; // Halve the power
        }

        // Adjust result based on the sign of n
        if (n < 0) {
            return 1 / result; // If n is negative, return reciprocal
        } else {
            return result;
        }
    }
}
