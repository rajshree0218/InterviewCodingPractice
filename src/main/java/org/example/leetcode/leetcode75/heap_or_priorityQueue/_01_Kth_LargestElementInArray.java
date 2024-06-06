package org.example.leetcode.leetcode75.heap_or_priorityQueue;

import java.util.PriorityQueue;

//215. Kth Largest Element in an Array
//Solved
//Medium
//Topics
//Companies
//Given an integer array nums and an integer k, return the kth largest element in the array.
//
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//Can you solve it without sorting?
//
//
//
//Example 1:
//
//Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
//Example 2:
//
//Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
//
//
//Constraints:
//
//1 <= k <= nums.length <= 10^5
//-104 <= nums[i] <= 10^4
public class _01_Kth_LargestElementInArray {

    public int findKthLargest2(int[] nums, int k) {
        // Create a min-heap with capacity k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Add the first k elements to the heap
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // Process the remaining elements
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        _01_Kth_LargestElementInArray solution = new _01_Kth_LargestElementInArray();
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(solution.findKthLargest(nums1, k1)); // Output: 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(solution.findKthLargest(nums2, k2)); // Output: 4
    }
}

