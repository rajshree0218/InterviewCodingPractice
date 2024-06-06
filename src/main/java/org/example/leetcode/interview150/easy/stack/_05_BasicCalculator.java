package org.example.leetcode.interview150.easy.stack;

import java.util.Stack;

//224. Basic Calculator
//Hard
//Topics
//Companies
//Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
//
//Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
//
//
//
//Example 1:
//
//Input: s = "1 + 1"
//Output: 2
//Example 2:
//
//Input: s = " 2-1 + 2 "
//Output: 3
//Example 3:
//
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
//
//
//Constraints:
//
//1 <= s.length <= 3 * 105
//s consists of digits, '+', '-', '(', ')', and ' '.
//s represents a valid expression.
//'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
//'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
//There will be no two consecutive operators in the input.
//Every number and running calculation will fit in a signed 32-bit integer.
public class _05_BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int operand = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                operand = operand * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * operand;
                operand = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * operand;
                operand = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * operand;
                operand = 0;
                result *= stack.pop(); // stack.pop() is the sign before the parenthesis
                result += stack.pop(); // stack.pop() is the result calculated before the parenthesis
            }
        }

        return result + (sign * operand);
    }

    public static void main(String[] args) {
        _05_BasicCalculator solution = new _05_BasicCalculator();

        // Example 1
        String s1 = "1 + 1";
        System.out.println("Output for Example 1: " + solution.calculate(s1)); // Output: 2

        // Example 2
        String s2 = " 2-1 + 2 ";
        System.out.println("Output for Example 2: " + solution.calculate(s2)); // Output: 3

        // Example 3
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("Output for Example 3: " + solution.calculate(s3)); // Output: 23
    }
}

