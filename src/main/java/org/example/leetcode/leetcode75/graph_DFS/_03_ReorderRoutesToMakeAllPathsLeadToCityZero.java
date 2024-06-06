package org.example.leetcode.leetcode75.graph_DFS;

import java.util.*;

//1466. Reorder Routes to Make All Paths Lead to the City Zero
//Solved
//Medium
//Topics
//Companies
//Hint
//There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
//
//Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
//
//This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
//
//Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
//
//It's guaranteed that each city can reach city 0 after reorder.
//
//
//
//Example 1:
//
//
//Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
//Output: 3
//Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
//Example 2:
//
//
//Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
//Output: 2
//Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
//Example 3:
//
//Input: n = 3, connections = [[1,0],[2,0]]
//Output: 0
//
//
//Constraints:
//
//2 <= n <= 5 * 104
//connections.length == n - 1
//connections[i].length == 2
//0 <= ai, bi <= n - 1
//ai != bi
public class _03_ReorderRoutesToMakeAllPathsLeadToCityZero {

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int[] changes = {0};

        for (int[] connection : connections) {
            int from = connection[0], to = connection[1];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(from).add(to);
            graph.get(to).add(-from);
        }

        dfs(graph, visited, 0, changes);

        return changes[0];
    }

    private void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int city, int[] changes)  {
        visited.add(city);
        List<Integer> neighbors = graph.get(city);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited.contains(Math.abs(neighbor))) {
                    if (neighbor > 0) { // Forward edge, need to reverse
                        changes[0]++;
                    }
                    dfs(graph, visited, Math.abs(neighbor), changes);
                }
            }
        }
    }

    public static void main(String[] args) {
        _03_ReorderRoutesToMakeAllPathsLeadToCityZero solution = new _03_ReorderRoutesToMakeAllPathsLeadToCityZero();

        // Example 1
        int n1 = 6;
        int[][] connections1 = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(solution.minReorder(n1, connections1)); // Output: 3

        // Example 2
        int n2 = 5;
        int[][] connections2 = {{1,0},{1,2},{3,2},{3,4}};
        System.out.println(solution.minReorder(n2, connections2)); // Output: 2

        // Example 3
        int n3 = 3;
        int[][] connections3 = {{1,0},{2,0}};
        System.out.println(solution.minReorder(n3, connections3)); // Output: 0
    }
}

