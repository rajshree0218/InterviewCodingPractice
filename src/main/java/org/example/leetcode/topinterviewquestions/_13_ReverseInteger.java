package org.example.leetcode.topinterviewquestions;

//Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//
//Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//
//
//
//Example 1:
//
//Input: x = 123
//Output: 321
//Example 2:
//
//Input: x = -123
//Output: -321
//Example 3:
//
//Input: x = 120
//Output: 21
//
//
//Constraints:
//
//-231 <= x <= 231 - 1
public class _13_ReverseInteger {
    public static int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow and underflow before updating reversed
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

    public static void main(String[] args) {
        int x1 = 123;
        int x2 = -123;
        int x3 = 120;

        System.out.println("Reversed " + x1 + " is: " + reverse(x1)); // Output: 321
        System.out.println("Reversed " + x2 + " is: " + reverse(x2)); // Output: -321
        System.out.println("Reversed " + x3 + " is: " + reverse(x3)); // Output: 21
    }
}
