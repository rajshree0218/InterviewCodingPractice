package org.example.leetcode.leetcode75.hashmapOrSet;

import java.util.HashMap;
import java.util.HashSet;

//1207. Unique Number of Occurrences
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
//
//
//
//Example 1:
//
//Input: arr = [1,2,2,1,1,3]
//Output: true
//Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
//Example 2:
//
//Input: arr = [1,2]
//Output: false
//Example 3:
//
//Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
//Output: true
//
//
//Constraints:
//
//1 <= arr.length <= 1000
//-1000 <= arr[i] <= 1000
public class _02_UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each element
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> occurrencesSet = new HashSet<>();

        // Check for duplicate counts
        for (int count : countMap.values()) {
            if (!occurrencesSet.add(count)) {
                return false; // Duplicate count found
            }
        }

        return true; // No duplicate counts found
    }

    public static void main(String[] args) {
        _02_UniqueNumberOfOccurrences solution = new _02_UniqueNumberOfOccurrences();

        // Example 1
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        System.out.println(solution.uniqueOccurrences(arr1)); // Output: true

        // Example 2
        int[] arr2 = {1, 2};
        System.out.println(solution.uniqueOccurrences(arr2)); // Output: false

        // Example 3
        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(solution.uniqueOccurrences(arr3)); // Output: true
    }
}
