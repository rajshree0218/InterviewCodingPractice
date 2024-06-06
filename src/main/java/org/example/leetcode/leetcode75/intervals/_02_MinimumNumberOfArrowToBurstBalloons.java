package org.example.leetcode.leetcode75.intervals;

import java.util.Arrays;

//452. Minimum Number of Arrows to Burst Balloons
//Solved
//Medium
//Topics
//Companies
//There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
//
//Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
//
//Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
//
//
//
//Example 1:
//
//Input: points = [[10,16],[2,8],[1,6],[7,12]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
//- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
//Example 2:
//
//Input: points = [[1,2],[3,4],[5,6],[7,8]]
//Output: 4
//Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
//Example 3:
//
//Input: points = [[1,2],[2,3],[3,4],[4,5]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
//- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
//
//
//Constraints:
//
//1 <= points.length <= 105
//points[i].length == 2
//-231 <= xstart < xend <= 231 - 1
public class _02_MinimumNumberOfArrowToBurstBalloons {

    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) return 0;

        // Sort balloons based on their end points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int end = points[0][1];

        // Iterate through balloons to find overlaps
        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            if (start > end) {
                // No overlap, need a new arrow
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int arrows = 1;
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prevEnd) {
                arrows++;
                prevEnd = points[i][1];
            } else {
                prevEnd = Math.min(prevEnd, points[i][1]);
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        _02_MinimumNumberOfArrowToBurstBalloons solution = new _02_MinimumNumberOfArrowToBurstBalloons();

        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(solution.findMinArrowShots(points1)); // Output: 2

        int[][] points2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(solution.findMinArrowShots(points2)); // Output: 4

        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(solution.findMinArrowShots(points3)); // Output: 2
    }
}

