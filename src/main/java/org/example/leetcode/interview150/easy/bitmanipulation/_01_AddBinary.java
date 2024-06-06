package org.example.leetcode.interview150.easy.bitmanipulation;

//67. Add Binary
//Easy
//Topics
//Companies
//Given two binary strings a and b, return their sum as a binary string.
//
//
//
//Example 1:
//
//Input: a = "11", b = "1"
//Output: "100"
//Example 2:
//
//Input: a = "1010", b = "1011"
//Output: "10101"
//
//
//Constraints:
//
//1 <= a.length, b.length <= 104
//a and b consist only of '0' or '1' characters.
//Each string does not contain leading zeros except for the zero itself.
public class _01_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        _01_AddBinary solution = new _01_AddBinary();

        String a1 = "11";
        String b1 = "1";
        System.out.println("Input: a = \"" + a1 + "\", b = \"" + b1 + "\"");
        System.out.println("Output: \"" + solution.addBinary(a1, b1) + "\"");

        String a2 = "1010";
        String b2 = "1011";
        System.out.println("\nInput: a = \"" + a2 + "\", b = \"" + b2 + "\"");
        System.out.println("Output: \"" + solution.addBinary(a2, b2) + "\"");
    }
}
