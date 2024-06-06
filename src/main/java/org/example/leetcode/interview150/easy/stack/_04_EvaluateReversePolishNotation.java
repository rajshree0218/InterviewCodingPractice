package org.example.leetcode.interview150.easy.stack;

import java.util.Stack;

//150. Evaluate Reverse Polish Notation
//Medium
//Topics
//Companies
//You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//
//Evaluate the expression. Return an integer that represents the value of the expression.
//
//Note that:
//
//The valid operators are '+', '-', '*', and '/'.
//Each operand may be an integer or another expression.
//The division between two integers always truncates toward zero.
//There will not be any division by zero.
//The input represents a valid arithmetic expression in a reverse polish notation.
//The answer and all the intermediate calculations can be represented in a 32-bit integer.
//
//
//Example 1:
//
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
//Example 2:
//
//Input: tokens = ["4","13","5","/","+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
//Example 3:
//
//Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//Output: 22
//Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
//
//
//Constraints:
//
//1 <= tokens.length <= 104
//tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
public class _04_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = performOperation(num1, num2, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int performOperation(int num1, int num2, String operator) {
        switch(operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        _04_EvaluateReversePolishNotation solution = new _04_EvaluateReversePolishNotation();

        // Example 1
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Output for Example 1: " + solution.evalRPN(tokens1)); // Output: 9

        // Example 2
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Output for Example 2: " + solution.evalRPN(tokens2)); // Output: 6

        // Example 3
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Output for Example 3: " + solution.evalRPN(tokens3)); // Output: 22
    }
}

