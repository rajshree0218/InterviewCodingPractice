package org.example.leetcode.leetcode75.intervals;

import java.util.Arrays;

//435. Non-overlapping Intervals
//Solved
//Medium
//Topics
//Companies
//Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
//
//
//
//Example 1:
//
//Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
//Example 2:
//
//Input: intervals = [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
//Example 3:
//
//Input: intervals = [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
//
//
//Constraints:
//
//1 <= intervals.length <= 105
//intervals[i].length == 2
//-5 * 104 <= starti < endi <= 5 * 104
public class _01_NonOverlappingIntervals {
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort intervals based on their end points
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int end = intervals[0][1];
        int count = 1; // Count of non-overlapping intervals

        // Iterate through intervals to find overlaps
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            if (start >= end) {
                // No overlap, update end and increment count
                end = intervals[i][1];
                count++;
            }
        }

        // Return the number of intervals to remove
        return intervals.length - count;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        _01_NonOverlappingIntervals solution = new _01_NonOverlappingIntervals();

        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(solution.eraseOverlapIntervals(intervals1)); // Output: 1

        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(solution.eraseOverlapIntervals(intervals2)); // Output: 2

        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println(solution.eraseOverlapIntervals(intervals3)); // Output: 0
    }
}

