package org.example.leetcode.leetcode75.backtracking;

import java.util.ArrayList;
import java.util.List;

//216. Combination Sum III
//Solved
//Medium
//Topics
//Companies
//Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
//Only numbers 1 through 9 are used.
//Each number is used at most once.
//Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
//
//
//
//Example 1:
//
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations.
//Example 2:
//
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
//Example 3:
//
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
//
//
//Constraints:
//
//2 <= k <= 9
//1 <= n <= 60
public class _02_CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int k, int remain, int start) {
        if (current.size() == k && remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > remain) break;
            current.add(i);
            backtrack(result, current, k, remain - i, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        _02_CombinationSum3 solution = new _02_CombinationSum3();

        int k1 = 3, n1 = 7;
        System.out.println(solution.combinationSum3(k1, n1)); // Output: [[1,2,4]]

        int k2 = 3, n2 = 9;
        System.out.println(solution.combinationSum3(k2, n2)); // Output: [[1,2,6],[1,3,5],[2,3,4]]

        int k3 = 4, n3 = 1;
        System.out.println(solution.combinationSum3(k3, n3)); // Output: []
    }
}

