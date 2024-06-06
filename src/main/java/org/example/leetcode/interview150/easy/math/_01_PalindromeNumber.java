package org.example.leetcode.interview150.easy.math;

//9. Palindrome Number
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an integer x, return true if x is a
//palindrome
//, and false otherwise.
//
//
//
//Example 1:
//
//Input: x = 121
//Output: true
//Explanation: 121 reads as 121 from left to right and from right to left.
//Example 2:
//
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//Example 3:
//
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//
//Constraints:
//
//-231 <= x <= 231 - 1
//
//
//Follow up: Could you solve it without converting the integer to a string?
public class _01_PalindromeNumber {
    public static void main(String[] args) {
        int x1 = 121;
        boolean output1 = true;

        int x2 = -121;
        boolean output2 = false;

        int x3 = 10;
        boolean output3 = false;

        if(isPalindrome(x1)==output1 && isPalindrome(x2)==output2 && isPalindrome(x3)==output3)
            System.out.println("All test are passed");
        else    System.out.println("There are failures");
    }

    //Time Complexity (TC): O(log10(n))
    //Space Complexity (SC): O(1)
    public static boolean isPalindrome(int x) {
        // Special cases:
        // As discussed above, if x < 0, x is not a palindrome.
        // Also, if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfies this property.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNumber = 0;
        // Reverse the second half of the number
        while (x > reversedNumber) {
            // Extracting the last digit of x and adding it to the reversed number.
            int lastDigit = x % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            // Removing the last digit from x.
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example, when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == reversedNumber || x == reversedNumber / 10;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int sum = 0;
        int copy = x;

        while (copy > 0) {
            sum = sum * 10 + (copy % 10);
            copy = copy / 10;
        }
        return sum == x;
    }
}
