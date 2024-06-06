package org.example.leetcode.interview150.easy.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//20. Valid Parentheses
//Solved
//Easy
//Topics
//Companies
//Hint
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//
//Example 1:
//
//Input: s = "()"
//Output: true
//Example 2:
//
//Input: s = "()[]{}"
//Output: true
//Example 3:
//
//Input: s = "(]"
//Output: false
//
//
//Constraints:
//
//1 <= s.length <= 104
//s consists of parentheses only '()[]{}'.
public class _01_ValidParentheses {

    // TC and SC O(n)
    public boolean isValid1(String s) {
        if (s == null || s.length() == 0) return true;

        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put(']', '[');
        mappings.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (mappings.containsValue(c)) {
                stack.push(c);
            } else if (mappings.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != mappings.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        _01_ValidParentheses solution = new _01_ValidParentheses();

        // Example 1
        String s1 = "()";
        System.out.println("Output for Example 1: " + solution.isValid(s1)); // Output: true

        // Example 2
        String s2 = "()[]{}";
        System.out.println("Output for Example 2: " + solution.isValid(s2)); // Output: true

        // Example 3
        String s3 = "(]";
        System.out.println("Output for Example 3: " + solution.isValid(s3)); // Output: false
    }

    // TC and SC : O(n)

    public boolean isValid(String s) {
        if(s==null || s.length()==0) return true;

        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((ch==')' && top!='(') ||  (ch==']' && top!='[') || (ch=='}' && top!='{') ){
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }
}

