package org.example.leetcode.leetcode75.heap_or_priorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//2542. Maximum Subsequence Score
//Medium
//Topics
//Companies
//Hint
//You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.
//
//For chosen indices i0, i1, ..., ik - 1, your score is defined as:
//
//The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
//It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
//Return the maximum possible score.
//
//A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.
//
//
//
//Example 1:
//
//Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
//Output: 12
//Explanation:
//The four possible subsequence scores are:
//- We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
//- We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6.
//- We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12.
//- We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
//Therefore, we return the max score, which is 12.
//Example 2:
//
//Input: nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
//Output: 30
//Explanation:
//Choosing index 2 is optimal: nums1[2] * nums2[2] = 3 * 10 = 30 is the maximum possible score.
//
//
//Constraints:
//
//n == nums1.length == nums2.length
//1 <= n <= 10^5
//0 <= nums1[i], nums2[j] <= 10^5
//1 <= k <= n
public class _03_MaxSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // Create a list of pairs (nums1[i], nums2[i])
        List<int[]> combined = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            combined.add(new int[]{nums1[i], nums2[i]});
        }

        // Sort the list based on the values of nums2 in descending order
        combined.sort((a, b) -> b[1] - a[1]);

        // Min-heap to keep track of the largest k elements in nums1
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        long sum = 0;
        long maxScore = 0;

        // Iterate through the sorted list
        for (int i = 0; i < n; i++) {
            int num1 = combined.get(i)[0];
            int num2 = combined.get(i)[1];

            // Add current num1 to the heap and to the sum
            minHeap.offer(num1);
            sum += num1;

            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            // If the heap size is exactly k, calculate the score
            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * num2);
            }
        }

        return maxScore;
    }

    // not working for example 1
    public long maxScore2(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int maxScore = Integer.MIN_VALUE;

        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) == k) {
                int[] selectedNums1 = new int[k];
                int[] selectedNums2 = new int[k];
                int idx = 0;
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        selectedNums1[idx] = nums1[i];
                        selectedNums2[idx] = nums2[i];
                        idx++;
                    }
                }
                Arrays.sort(selectedNums2);
                int score = 0;
                for (int i = 0; i < k; i++) {
                    score += selectedNums1[i] * selectedNums2[i];
                }
                maxScore = Math.max(maxScore, score);
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        _03_MaxSubsequenceScore solution = new _03_MaxSubsequenceScore();
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;
        System.out.println(solution.maxScore(nums1, nums2, k)); // Output: 12

        nums1 = new int[]{4, 2, 3, 1, 1};
        nums2 = new int[]{7, 5, 10, 9, 6};
        k = 1;
        System.out.println(solution.maxScore(nums1, nums2, k)); // Output: 30
    }
}
