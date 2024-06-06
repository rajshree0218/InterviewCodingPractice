package org.example.leetcode.interview150.easy.stack;

import java.util.Stack;

//155. Min Stack
//Medium
//Topics
//Companies
//Hint
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//Implement the MinStack class:
//
//MinStack() initializes the stack object.
//void push(int val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//You must implement a solution with O(1) time complexity for each function.
//
//
//
//Example 1:
//
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
//
//
//Constraints:
//
//-231 <= val <= 231 - 1
//Methods pop, top and getMin operations will always be called on non-empty stacks.
//At most 3 * 104 calls will be made to push, pop, top, and getMin.
public class _03_MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public _03_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int popped = stack.pop();
        if (popped == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1; // Assuming -1 as error value for empty stack
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) return -1; // Assuming -1 as error value for empty stack
        return minStack.peek();
    }

    public static void main(String[] args) {
        _03_MinStack minStack = new _03_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Minimum element in the stack: " + minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println("Top element of the stack: " + minStack.top()); // Output: 0
        System.out.println("Minimum element in the stack: " + minStack.getMin()); // Output: -2
    }
}

