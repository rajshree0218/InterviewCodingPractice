package org.example.leetcode.leetcode75.prefixSum;

//1732. Find the Highest Altitude
//Solved
//Easy
//Topics
//Companies
//Hint
//There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
//
//You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
//
//
//
//Example 1:
//
//Input: gain = [-5,1,5,0,-7]
//Output: 1
//Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
//Example 2:
//
//Input: gain = [-4,-3,-2,-1,4,3,2]
//Output: 0
//Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
//
//
//Constraints:
//
//n == gain.length
//1 <= n <= 100
//-100 <= gain[i] <= 100
public class _01_FindHighestAltitude {

    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;

        for (int g : gain) {
            currentAltitude += g;
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }

        return maxAltitude;
    }

    public static void main(String[] args) {
        _01_FindHighestAltitude solution = new _01_FindHighestAltitude();

        // Example 1
        int[] gain1 = {-5, 1, 5, 0, -7};
        System.out.println(solution.largestAltitude(gain1)); // Output: 1

        // Example 2
        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println(solution.largestAltitude(gain2)); // Output: 0
    }
}
