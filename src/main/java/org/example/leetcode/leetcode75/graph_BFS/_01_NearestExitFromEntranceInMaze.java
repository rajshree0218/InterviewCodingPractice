package org.example.leetcode.leetcode75.graph_BFS;

import java.util.LinkedList;
import java.util.Queue;

//1926. Nearest Exit from Entrance in Maze
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
//
//In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.
//
//Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
//
//
//
//Example 1:
//
//
//Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
//Output: 1
//Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
//Initially, you are at the entrance cell [1,2].
//- You can reach [1,0] by moving 2 steps left.
//- You can reach [0,2] by moving 1 step up.
//It is impossible to reach [2,3] from the entrance.
//Thus, the nearest exit is [0,2], which is 1 step away.
//Example 2:
//
//
//Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
//Output: 2
//Explanation: There is 1 exit in this maze at [1,2].
//[1,0] does not count as an exit since it is the entrance cell.
//Initially, you are at the entrance cell [1,0].
//- You can reach [1,2] by moving 2 steps right.
//Thus, the nearest exit is [1,2], which is 2 steps away.
//Example 3:
//
//
//Input: maze = [[".","+"]], entrance = [0,0]
//Output: -1
//Explanation: There are no exits in this maze.
//
//
//Constraints:
//
//maze.length == m
//maze[i].length == n
//1 <= m, n <= 100
//maze[i][j] is either '.' or '+'.
//entrance.length == 2
//0 <= entrancerow < m
//0 <= entrancecol < n
//entrance will always be an empty cell.
public class _01_NearestExitFromEntranceInMaze {

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});  // Add steps as the third element
        maze[entrance[0]][entrance[1]] = '+';

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX < 0 || newX >= m || newY < 0 || newY >= n || maze[newX][newY] == '+') {
                    continue;
                }

                if (newX == 0 || newX == m - 1 || newY == 0 || newY == n - 1) {
                    return steps + 1;
                }

                maze[newX][newY] = '+';
                queue.offer(new int[]{newX, newY, steps + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        _01_NearestExitFromEntranceInMaze solution = new _01_NearestExitFromEntranceInMaze();

        char[][] maze1 = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance1 = {1, 2};
        System.out.println(solution.nearestExit(maze1, entrance1));  // Output: 1

        char[][] maze2 = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        int[] entrance2 = {1, 0};
        System.out.println(solution.nearestExit(maze2, entrance2));  // Output: 2

        char[][] maze3 = {{'.', '+'}};
        int[] entrance3 = {0, 0};
        System.out.println(solution.nearestExit(maze3, entrance3));  // Output: -1
    }
}
