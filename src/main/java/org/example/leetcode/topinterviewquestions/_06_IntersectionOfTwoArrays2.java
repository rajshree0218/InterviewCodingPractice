package org.example.leetcode.topinterviewquestions;

import java.util.*;

//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
//Example 2:
//
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9]
//Explanation: [9,4] is also accepted.
//
//
//Constraints:
//
//1 <= nums1.length, nums2.length <= 1000
//0 <= nums1[i], nums2[i] <= 1000
//
//
//Follow up:
//
//What if the given array is already sorted? How would you optimize your algorithm?
//What if nums1's size is small compared to nums2's size? Which algorithm is better?
//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
public class _06_IntersectionOfTwoArrays2 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] output1 = {2,2};

        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};
        int[] output2 = {4,9};
        int[] output2_ = {9,4};

        int[] result1 = intersect(nums1, nums2);
        System.out.println("Intersection: " + Arrays.toString(result1)); // Output: [2, 2]

        int[] result2 = intersect(nums3, nums4);
        System.out.println("Intersection: " + Arrays.toString(result2)); // Output: [4, 9] or [9, 4]
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // Use a HashMap to count occurrences of elements in nums1
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums1) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Use a List to collect the intersection results
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (counts.containsKey(num) && counts.get(num) > 0) {
                result.add(num);
                counts.put(num, counts.get(num) - 1);
            }
        }

        // Convert the List to an array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    //Follow-up Considerations:
    //Already Sorted Arrays:
    //
    //If the arrays are already sorted, we can use two pointers to find the intersection. This would improve the time complexity by avoiding the need for a HashMap.
    //Small Size of nums1 Compared to nums2:
    //
    //If nums1 is significantly smaller than nums2, the HashMap approach remains efficient as it minimizes the space used for counting frequencies.
    //Elements of nums2 Stored on Disk:
    //
    //If nums2 is too large to load into memory, we can read nums2 in chunks, maintaining a running count of the intersection using a HashMap for nums1.
    //Here is the implementation with sorted arrays optimization:
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }

        // Convert the result list to an array
        int[] resultArray = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            resultArray[k] = result.get(k);
        }

        return resultArray;
    }

}
