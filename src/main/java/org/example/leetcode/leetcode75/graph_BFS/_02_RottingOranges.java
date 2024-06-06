package org.example.leetcode.leetcode75.graph_BFS;

import java.util.LinkedList;
import java.util.Queue;

//994. Rotting Oranges
//Solved
//Medium
//Topics
//Companies
//You are given an m x n grid where each cell can have one of three values:
//
//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
//
//
//
//Example 1:
//
//
//Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
//Example 2:
//
//Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
//Example 3:
//
//Input: grid = [[0,2]]
//Output: 0
//Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 10
//grid[i][j] is 0, 1, or 2.
public class _02_RottingOranges {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Initialize the queue with all the initially rotten oranges and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // Directions for moving up, down, left, and right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int minutes = 0;

        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];

                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    // Check if the new position is within bounds and has a fresh orange
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Rot the fresh orange
                        queue.offer(new int[]{newX, newY}); // Add it to the queue
                        freshOranges--;
                    }
                }
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }

    public int orangesRotting2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0;

        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        _02_RottingOranges solution = new _02_RottingOranges();

        int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(solution.orangesRotting(grid1)); // Output: 4

        int[][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(solution.orangesRotting(grid2)); // Output: -1

        int[][] grid3 = {{0,2}};
        System.out.println(solution.orangesRotting(grid3)); // Output: 0
    }
}
