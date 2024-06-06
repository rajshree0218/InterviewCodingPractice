package org.example.leetcode.interview150.medium.arrayandstring;

//189. Rotate Array
//Medium
//Topics
//Companies
//Hint
//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
//Example 2:
//
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation:
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-231 <= nums[i] <= 231 - 1
//0 <= k <= 105
//
//
//Follow up:
//
//Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
//Could you do it in-place with O(1) extra space?ssss
public class _06_ArrayRotate {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
//        rotate(nums1, k1);
        rotateWithoutRecursion(nums1, k1);
        System.out.println("Right Rotated array: ");
        printArray(nums1); // Output: [5, 6, 7, 1, 2, 3, 4]

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
//        rotate(nums2, k2);
        rotateWithoutRecursion(nums2, k2);
        System.out.println("Right Rotated array: ");
        printArray(nums2); // Output: [3, 99, -1, -100]
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        int index=0;
        for(int i=k;i<n;i++){
            temp[index++] = nums[i];
        }
        for(int i=0; i<k;i++){
            temp[index++] = nums[i];
        }
        for(int i=0; i<n;i++){
            nums[i] = temp[i];
        }
    }

    public static void rotateWithoutRecursion(int[] nums, int k) {
        int n = nums.length;
        k %= n; // Adjust k if it is greater than the length of the array

        int count = 0;
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
