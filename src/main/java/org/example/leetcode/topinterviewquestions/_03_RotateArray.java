package org.example.leetcode.topinterviewquestions;

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
//Could you do it in-place with O(1) extra space?
public class _03_RotateArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7};
        int k1 = 3;
        int[] output1 = {5,6,7,1,2,3,4,5};

        int[] nums2 = {-1,-100,3,99};
        int k2 = 2;
        int[] output2 = {3,99,-1,-100};

        rotate(nums1, k1);
        rotate(nums2, k2);

        nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate2(nums1, k1);


    }

    public static void rotate(int[] nums, int k){
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //using extra array
    public static void rotate2(int[] nums, int k){

        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }

        int n = nums.length;
        k %= n;
        int[] temp = new int[n];

        // Copy the last k elements to the beginning of the temp array
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        // Copy the first n-k elements to the end of the temp array
        for (int i = k; i < n; i++) {
            temp[i] = nums[i - k];
        }

        for(int i=0; i<n; i++){
            nums[i] = temp[i];
        }
    }

    // using cyclic approach
    public static void rotate3(int[] nums, int k){

        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }

        int n = nums.length;
        k = k % n;
        int count = 0; // number of elements rotated

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

    //brute force
    public void rotate4(int[] nums, int k) {
        int last = nums[nums.length-1];
        for(int i=0; i<k; i++){
            last = nums[nums.length-1];
            for(int j=nums.length-1; j>0; j--){
                nums[j] = nums[j-1];
            }
            nums[0] = last;
        }
    }
}
