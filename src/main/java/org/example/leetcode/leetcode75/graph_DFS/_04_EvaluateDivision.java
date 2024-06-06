package org.example.leetcode.leetcode75.graph_DFS;

import java.util.*;

//399. Evaluate Division
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
//
//You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
//
//Return the answers to all queries. If a single answer cannot be determined, return -1.0.
//
//Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
//
//Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
//
//
//
//Example 1:
//
//Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
//Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
//Explanation:
//Given: a / b = 2.0, b / c = 3.0
//queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
//note: x is undefined => -1.0
//Example 2:
//
//Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//Output: [3.75000,0.40000,5.00000,0.20000]
//Example 3:
//
//Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
//Output: [0.50000,2.00000,-1.00000,-1.00000]
//
//
//Constraints:
//
//1 <= equations.length <= 20
//equations[i].length == 2
//1 <= Ai.length, Bi.length <= 5
//values.length == equations.length
//0.0 < values[i] <= 20.0
//1 <= queries.length <= 20
//queries[i].length == 2
//1 <= Cj.length, Dj.length <= 5
//Ai, Bi, Cj, Dj consist of lower case English letters and digits.
public class _04_EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            results[i] = evaluate(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
        }
        return results;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double value = values[i];
            graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, value);
            graph.computeIfAbsent(to, k -> new HashMap<>()).put(from, 1 / value);
        }
        return graph;
    }

    private double evaluate(String from, String to, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(from) || !graph.containsKey(to)) return -1.0;
        if (from.equals(to)) return 1.0;
        visited.add(from);
        for (String neighbor : graph.get(from).keySet()) {
            if (!visited.contains(neighbor)) {
                double result = evaluate(neighbor, to, graph, visited);
                if (result != -1.0) {
                    return graph.get(from).get(neighbor) * result;
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        _04_EvaluateDivision solution = new _04_EvaluateDivision();

        // Example 1
        List<List<String>> equations1 = new ArrayList<>();
        equations1.add(Arrays.asList("a","b"));
        equations1.add(Arrays.asList("b","c"));
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = new ArrayList<>();
        queries1.add(Arrays.asList("a","c"));
        queries1.add(Arrays.asList("b","a"));
        queries1.add(Arrays.asList("a","e"));
        queries1.add(Arrays.asList("a","a"));
        queries1.add(Arrays.asList("x","x"));
        System.out.println(Arrays.toString(solution.calcEquation(equations1, values1, queries1)));

        // Example 2
        List<List<String>> equations2 = new ArrayList<>();
        equations2.add(Arrays.asList("a","b"));
        equations2.add(Arrays.asList("b","c"));
        equations2.add(Arrays.asList("bc","cd"));
        double[] values2 = {1.5, 2.5, 5.0};
        List<List<String>> queries2 = new ArrayList<>();
        queries2.add(Arrays.asList("a","c"));
        queries2.add(Arrays.asList("c","b"));
        queries2.add(Arrays.asList("bc","cd"));
        queries2.add(Arrays.asList("cd","bc"));
        System.out.println(Arrays.toString(solution.calcEquation(equations2, values2, queries2)));

        // Example 3
        List<List<String>> equations3 = new ArrayList<>();
        equations3.add(Arrays.asList("a","b"));
        double[] values3 = {0.5};
        List<List<String>> queries3 = new ArrayList<>();
        queries3.add(Arrays.asList("a","b"));
        queries3.add(Arrays.asList("b","a"));
        queries3.add(Arrays.asList("a","c"));
        queries3.add(Arrays.asList("x","y"));
        System.out.println(Arrays.toString(solution.calcEquation(equations3, values3, queries3)));
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double w = values[i];
            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(u).put(v, w);
            graph.get(v).put(u, 1.0 / w); // Inverse edge
        }

        // Evaluate queries
        int m = queries.size();
        double[] result = new double[m];
        for (int i = 0; i < m; i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0; // One or both nodes not found
            } else if (start.equals(end)) {
                result[i] = 1.0; // Same node
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, start, end, visited);
            }
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if (!graph.containsKey(start)) return -1.0;
        if (graph.get(start).containsKey(end)) return graph.get(start).get(end);
        visited.add(start);
        for (Map.Entry<String, Double> neighbor : graph.get(start).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double val = dfs(graph, neighbor.getKey(), end, visited);
                if (val != -1.0) return neighbor.getValue() * val;
            }
        }
        return -1.0;
    }
}
