package org.example.leetcode.leetcode75.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

//739. Daily Temperatures
//Solved
//Medium
//Topics
//Companies
//Hint
//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
//
//
//
//Example 1:
//
//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
//Example 2:
//
//Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]
//Example 3:
//
//Input: temperatures = [30,60,90]
//Output: [1,1,0]
//
//
//Constraints:
//
//1 <= temperatures.length <= 105
//30 <= temperatures[i] <= 100
public class _01_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        _01_DailyTemperatures solution = new _01_DailyTemperatures();

        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures1))); // Output: [1, 1, 4, 2, 1, 1, 0, 0]

        int[] temperatures2 = {30, 40, 50, 60};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures2))); // Output: [1, 1, 1, 0]

        int[] temperatures3 = {30, 60, 90};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures3))); // Output: [1, 1, 0]
    }
}
