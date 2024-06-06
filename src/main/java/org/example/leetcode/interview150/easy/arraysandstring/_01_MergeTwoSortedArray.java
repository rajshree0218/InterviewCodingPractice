package org.example.leetcode.interview150.easy.arraysandstring;

import java.util.Arrays;

//You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//Example 2:
//
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
//Example 3:
//
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
//
//
//Constraints:
//
//nums1.length == m + n
//nums2.length == n
//0 <= m, n <= 200
//1 <= m + n <= 200
//-109 <= nums1[i], nums2[j] <= 109
//
//
//Follow up: Can you come up with an algorithm that runs in O(m + n) time?
public class _01_MergeTwoSortedArray {
    public static void main(String[] args) {

        // input
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        // o/p: [1,2,2,3,5,6]

        // i/p
        int[] nums12 = {1};
        int m2 = 1;
        int[] nums22 = {};
        int n2 = 0;
        // o/p:  [1]

        //i/p: below
        int[] nums13 = {0};
        int m3 = 0;
        int[] nums23 = {1};
        int n3 = 1;
        //o/p:  [1]

//        int[] arr = merge(nums1, nums2, m, n);
        boolean result = true;
        result = result && Arrays.equals(merge(nums1, m, nums2, n), new int[]{1, 2, 2, 3, 5, 6});
        result = result && Arrays.equals(merge(new int[]{1,2,4,0,0,0}, 3, new int[]{1,3,5}, 3), new int[]{1, 1, 2, 3, 4, 5});
        result = result && Arrays.equals(merge(new int[]{1,2,4}, new int[]{1,3,5,0,0,0}, 3, 3), new int[]{1, 1, 2, 3, 4, 5});
        result = result && Arrays.equals(merge(nums12, m2, nums22, n2), new int[]{1});
        result = result && Arrays.equals(merge(nums13, m3, nums23, n3), new int[]{1});

        if(result)
            System.out.println("All tests are passed");
        else
            System.out.println("There are test failure");

        for(int i=5; i>=0;i--) {
            if (i > 0)
                System.out.println(i);
            else if (i >= 0) System.out.println(i+" >= 0");
        }


    }
    public static int[] merge(int[] num1, int[] num2, int m, int n) {
        int i=m-1,j=n-1, k=m+n-1;
        while(i>=0 && j>=0){
            if(num1[i]>num2[j]){
                num2[k--] = num1[i--];
            } else {
                num2[k--] = num2[j--];
            }
        }

        while(j>=0) {
            num2[k--] = num2[j--];
        }
        return num2;
    }
    public static int[] merge(int[] num1, int m, int[] num2, int n) {
        int i=m-1,j=n-1, k=m+n-1;
        while(i>=0 && j>=0){
            if(num1[i]>num2[j]){
                num1[k--] = num1[i--];
            } else {
                num1[k--] = num2[j--];
            }
        }

        while(j>=0) {
            num1[k--] = num2[j--];
        }
        return num1;
    }
}
