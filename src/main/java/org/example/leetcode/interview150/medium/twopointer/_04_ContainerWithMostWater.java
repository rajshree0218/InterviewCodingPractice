package org.example.leetcode.interview150.medium.twopointer;

//11. Container With Most Water
//Medium
//Topics
//Companies
//Hint
//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.
//
//
//
//Example 1:
//
//
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
//Example 2:
//
//Input: height = [1,1]
//Output: 1
//
//
//Constraints:
//
//n == height.length
//2 <= n <= 105
//0 <= height[i] <= 104
public class _04_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Output for height1: " + maxArea(height1));

        int[] height2 = {1, 1};
        System.out.println("Output for height2: " + maxArea(height2));
    }

    // TC : O(n), SC : O(1)
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = minHeight * width;
            maxArea = Math.max(maxArea, area);

            // Move the pointer with the smaller height towards the other pointer
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }


}
