package org.example.leetcode.leetcode75.hashmapOrSet;

import java.util.HashMap;
import java.util.Map;

//2352. Equal Row and Column Pairs
//Solved
//Medium
//Topics
//Companies
//Hint
//Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
//
//A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
//
//
//
//Example 1:
//
//
//Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
//Output: 1
//Explanation: There is 1 equal row and column pair:
//- (Row 2, Column 1): [2,7,7]
//Example 2:
//
//
//Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
//Output: 3
//Explanation: There are 3 equal row and column pairs:
//- (Row 0, Column 0): [3,1,2,2]
//- (Row 2, Column 2): [2,4,2,2]
//- (Row 3, Column 2): [2,4,2,2]
//
//
//Constraints:
//
//n == grid.length == grid[i].length
//1 <= n <= 200
//1 <= grid[i][j] <= 10^5
public class _04_EqualRowAndColPair {

    public int countEqualPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> rowCountMap = new HashMap<>();
        HashMap<String, Integer> colCountMap = new HashMap<>();
        int equalPairs = 0;

        // Iterate through each row and column
        for (int i = 0; i < n; i++) {
            StringBuilder rowStr = new StringBuilder();
            StringBuilder colStr = new StringBuilder();

            for (int j = 0; j < n; j++) {
                rowStr.append(grid[i][j]);
                colStr.append(grid[j][i]);
            }

            // Check row
            String rowKey = rowStr.toString();
            if (rowCountMap.containsKey(rowKey)) {
                equalPairs += rowCountMap.get(rowKey);
            }
            rowCountMap.put(rowKey, rowCountMap.getOrDefault(rowKey, 0) + 1);

            // Check column
            String colKey = colStr.toString();
            if (colCountMap.containsKey(colKey)) {
                equalPairs += colCountMap.get(colKey);
            }
            colCountMap.put(colKey, colCountMap.getOrDefault(colKey, 0) + 1);
        }

        return equalPairs;
    }

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowCount = new HashMap<>();
        Map<String, Integer> colCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder rowKey = new StringBuilder();
            StringBuilder colKey = new StringBuilder();
            for (int j = 0; j < n; j++) {
                rowKey.append(grid[i][j]).append(',');
                colKey.append(grid[j][i]).append(',');
            }
            rowCount.put(rowKey.toString(), rowCount.getOrDefault(rowKey.toString(), 0) + 1);
            colCount.put(colKey.toString(), colCount.getOrDefault(colKey.toString(), 0) + 1);
        }

        int equalPairs = 0;
        for (String key : rowCount.keySet()) {
            if (colCount.containsKey(key)) {
                equalPairs += rowCount.get(key) * colCount.get(key);
            }
        }

        return equalPairs;
    }

    public static void main(String[] args) {
        _04_EqualRowAndColPair solution = new _04_EqualRowAndColPair();

        // Example 1
        int[][] grid1 = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(solution.equalPairs(grid1)); // Output: 1

        // Example 2
        int[][] grid2 = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        System.out.println(solution.equalPairs(grid2)); // Output: 3
    }
}
