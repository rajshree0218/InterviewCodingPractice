package org.example.leetcode.dailyChallenges.may;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//3068. Find the Maximum Sum of Node Values
//Hard
//Topics
//Companies
//Hint
//There exists an undirected tree with n nodes numbered 0 to n - 1. You are given a 0-indexed 2D integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the tree. You are also given a positive integer k, and a 0-indexed array of non-negative integers nums of length n, where nums[i] represents the value of the node numbered i.
//
//Alice wants the sum of values of tree nodes to be maximum, for which Alice can perform the following operation any number of times (including zero) on the tree:
//
//Choose any edge [u, v] connecting the nodes u and v, and update their values as follows:
//nums[u] = nums[u] XOR k
//nums[v] = nums[v] XOR k
//Return the maximum possible sum of the values Alice can achieve by performing the operation any number of times.
//
//
//
//Example 1:
//
//
//Input: nums = [1,2,1], k = 3, edges = [[0,1],[0,2]]
//Output: 6
//Explanation: Alice can achieve the maximum sum of 6 using a single operation:
//- Choose the edge [0,2]. nums[0] and nums[2] become: 1 XOR 3 = 2, and the array nums becomes: [1,2,1] -> [2,2,2].
//The total sum of values is 2 + 2 + 2 = 6.
//It can be shown that 6 is the maximum achievable sum of values.
//Example 2:
//
//
//Input: nums = [2,3], k = 7, edges = [[0,1]]
//Output: 9
//Explanation: Alice can achieve the maximum sum of 9 using a single operation:
//- Choose the edge [0,1]. nums[0] becomes: 2 XOR 7 = 5 and nums[1] become: 3 XOR 7 = 4, and the array nums becomes: [2,3] -> [5,4].
//The total sum of values is 5 + 4 = 9.
//It can be shown that 9 is the maximum achievable sum of values.
//Example 3:
//
//
//Input: nums = [7,7,7,7,7,7], k = 3, edges = [[0,1],[0,2],[0,3],[0,4],[0,5]]
//Output: 42
//Explanation: The maximum achievable sum is 42 which can be achieved by Alice performing no operations.
//
//
//Constraints:
//
//2 <= n == nums.length <= 2 * 10^4
//1 <= k <= 10^9
//0 <= nums[i] <= 10^9
//edges.length == n - 1
//edges[i].length == 2
//0 <= edges[i][0], edges[i][1] <= n - 1
//The input is generated such that edges represent a valid tree.
public class _19_MaximumSumOfNodeValues {

    public static void main(String[] args) {
        // Example test case
        int[] nums = {1, 2, 1};
        int k = 3;
        int[][] edges = {{0, 1}, {0, 2}};
        System.out.println(maximumValueSum(nums, k, edges)); // Output: 6

        //Input
        //nums =
        //[2,3]
        //k =
        //7
        //edges =
        //[[0,1]]
        //Output
        //9
        //Expected
        //9

        //Input
        //nums =
        //[7,7,7,7,7,7]
        //k =
        //3
        //edges =
        //[[0,1],[0,2],[0,3],[0,4],[0,5]]
        //Output
        //42
        //Expected
        //42

        //Input
        //nums =
        //[78,43,92,97,95,94]
        //k =
        //6
        //edges =
        //[[1,2],[3,0],[4,0],[0,1],[1,5]]
        //Output
        //507
        //Expected
        //507

        //Input
        //nums =
        //[209,194,33,176,175,130,206,86,109,53,67,130,137,245,140,141,40,136,58,221,124,94,47,56,89,121,54,59,47,140,111,63,41,72,209,83,95,25,212,41,53,143,112,80,238,141,18,62,237,44,181,182,113,154,117,35,229,96,123,214,52,217,141,67,176,157,55,171,67,73,248,14,59,122,201,229,146,165,63,248,186,19,164,73,63,144,28,190,90,94,40,234,123,81,149,14,173,105,181,32,159,36,164,40,249,218,185,48,84,19,55,36,194,21,28,54,189,25,42,200,100,130,169,59,231,145,38,21,157,87,99,132,122,248,137,244,118,229,181,173,21,214,138,86,132,54,227,206,188,215,52,142,104,205,83,223,11,46,218,106,21,203,231,10,32,238,175,161,93,147,187,19,137,176,207,230,227,132,211,54,207,39,176,124,167,238,99,137,147,27,178,1
        //View more
        //k =
        //828
        //edges =
        //[[0,403],[489,3],[4,112],[271,8],[9,718],[14,72],[15,621],[497,20],[576,22],[24,515],[27,255],[179,28],[595,29],[30,712],[31,545],[438,33],[567,34],[388,35],[629,36],[37,545],[410,39],[42,79],[414,46],[10,49],[52,553],[55,53],[252,54],[466,55],[57,755],[645,58],[80,60],[64,130],[66,498],[68,647],[69,403],[553,70],[103,72],[77,398],[80,561],[236,83],[84,438],[85,710],[100,772],[101,240],[102,608],[108,363],[698,113],[239,117],[172,119],[122,725],[125,289],[569,127],[552,129],[131,180],[134,750],[137,153],[139,81],[81,527],[141,208],[144,490],[75,147],[148,626],[655,151],[154,672],[764,158],[452,159],[44,161],[44,614],[47,162],[166,441],[167,298],[169,751],[172,358],[259,175],[646,
        //View more
        //Output
        //699695
        //Expected
        //699695


    }

    //Approach-1 (Greedily picking nodes to xor)
    //T.C : O(n)
    //S.C : O(1)
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {

        long sum = 0;
        int count = 0;
        int minLoss = Integer.MAX_VALUE;

        for (int num : nums) {
            if ((num ^ k) > num) {
                count++;
                sum += (num ^ k);
            } else {
                sum += num;
            }

            minLoss = Math.min(minLoss, Math.abs(num - (num ^ k)));
        }

        if (count % 2 == 0)
            return sum;

        return sum - minLoss;
    }

}
//Approach-2(Greedy  + Sorting)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        List<Integer> profit = new ArrayList<>();
        long normalSum = 0;

        for (int num : nums) {
            profit.add((num ^ k) - num);
            normalSum += (long) num;
        }

        Collections.sort(profit, Collections.reverseOrder());

        for (int i = 0; i < profit.size() - 1; i += 2) {
            long pairSum = profit.get(i) + profit.get(i + 1);

            if (pairSum > 0) {
                normalSum += pairSum;
            }
        }
        return normalSum;
    }
}

