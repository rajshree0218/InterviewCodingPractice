package org.example.leetcode.leetcode75.stack;

import java.util.Arrays;
import java.util.Stack;

//735. Asteroid Collision
//Solved
//Medium
//Topics
//Companies
//Hint
//We are given an array asteroids of integers representing asteroids in a row.
//
//For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
//Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
//
//
//
//Example 1:
//
//Input: asteroids = [5,10,-5]
//Output: [5,10]
//Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
//Example 2:
//
//Input: asteroids = [8,-8]
//Output: []
//Explanation: The 8 and -8 collide exploding each other.
//Example 3:
//
//Input: asteroids = [10,2,-5]
//Output: [10]
//Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
//
//
//Constraints:
//
//2 <= asteroids.length <= 10^4
//-1000 <= asteroids[i] <= 1000
//asteroids[i] != 0
public class _02_AsteroidCollision {
    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean exploded = false;

            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (Math.abs(asteroid) > stack.peek()) {
                    stack.pop();  // The right-moving asteroid is smaller and explodes
                } else if (Math.abs(asteroid) == stack.peek()) {
                    stack.pop();  // Both asteroids are the same size and both explode
                    exploded = true;
                    break;
                } else {
                    exploded = true;
                    break;
                }
            }

            if (!exploded) {
                stack.push(asteroid);
            }
        }

        // Convert the stack to an array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        _02_AsteroidCollision solution = new _02_AsteroidCollision();

        // Example 1
        int[] asteroids1 = {5, 10, -5};
        int[] result1 = solution.asteroidCollision(asteroids1);
        System.out.println(Arrays.toString(result1));  // Output: [5, 10]

        // Example 2
        int[] asteroids2 = {8, -8};
        int[] result2 = solution.asteroidCollision(asteroids2);
        System.out.println(Arrays.toString(result2));  // Output: []

        // Example 3
        int[] asteroids3 = {10, 2, -5};
        int[] result3 = solution.asteroidCollision(asteroids3);
        System.out.println(Arrays.toString(result3));  // Output: [10]
    }
}
