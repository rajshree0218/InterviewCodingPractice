package org.example.leetcode.interview150.high.math;

import java.util.HashMap;
import java.util.Map;

//149. Max Points on a Line
//Hard
//Topics
//Companies
//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
//
//
//
//Example 1:
//
//
//Input: points = [[1,1],[2,2],[3,3]]
//Output: 3
//Example 2:
//
//
//Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//Output: 4
//
//
//Constraints:
//
//1 <= points.length <= 300
//points[i].length == 2
//-104 <= xi, yi <= 104
//All the points are unique.
public class _06_MaxPointsOnLine {
    public static void main(String[] args) {
        int[][] points1 = {{1,1},{2,2},{3,3}};
        System.out.println("Output for points1: " + maxPoints(points1));

        int[][] points2 = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println("Output for points2: " + maxPoints(points2));

    }

    public static int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length; // If there are 2 or fewer points, they all lie on the same line
        }

        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>(); // Map to store slope counts

            int samePointCount = 0; // Count of points that are the same as points[i]
            int verticalLineCount = 0; // Count of vertical lines

            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue; // Skip the same point
                }

                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                // Calculate slope
                int dx = x2 - x1;
                int dy = y2 - y1;

                // Handle vertical lines separately
                if (dx == 0) {
                    if (dy == 0) {
                        samePointCount++;
                    } else {
                        verticalLineCount++;
                    }
                    continue;
                }

                // Calculate the slope as a string to avoid precision issues
                String slope = calculateSlope(dx, dy);

                // Update slope count in the hashmap
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
            }

            // Update maxPoints considering points that lie on the same line
            for (int count : slopeCount.values()) {
                maxPoints = Math.max(maxPoints, count + samePointCount);
            }
            // Update maxPoints considering vertical lines
            maxPoints = Math.max(maxPoints, verticalLineCount + samePointCount + 1);
        }

        return maxPoints;
    }

    // Calculate slope as a string to avoid precision issues
    private static String calculateSlope(int dx, int dy) {
        int gcd = gcd(dx, dy);
        return (dy / gcd) + "/" + (dx / gcd); // Slope represented as a fraction
    }

    // Calculate greatest common divisor using Euclidean algorithm
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    //Time Complexity (TC): O(n^3)
    //Space Complexity (SC): O(1)
    public static int maxPoints2(int[][] points) {
        if(points.length <= 2){
            return points.length;
        }

        int maxPoints = 0;

        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                int count = 2;

                int dx1 = points[j][0] - points[i][0];
                int dy1 = points[j][1] - points[i][1];

                for(int k=0; k<points.length; k++){
                    if(k==i || k==j){
                        continue;
                    }

                    long dx2 = points[k][0] - points[i][0];
                    long dy2 = points[k][1] - points[i][1];

                    if(dx1*dy2 == dx2*dy1){
                        count++;
                    }
                }
                maxPoints = (maxPoints > count) ? maxPoints : count;
            }
        }
        return maxPoints;
    }

}
