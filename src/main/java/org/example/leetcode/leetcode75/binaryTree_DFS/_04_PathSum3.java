package org.example.leetcode.leetcode75.binaryTree_DFS;

import java.util.HashMap;
import java.util.Map;

//437. Path Sum III
//Attempted
//Medium
//Topics
//Companies
//Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
//
//The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
//
//
//
//Example 1:
//
//
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
//Example 2:
//
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 1000].
//-109 <= Node.val <= 109
//-1000 <= targetSum <= 1000
public class _04_PathSum3 {
}

class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);  // Base case to handle the situation where the path sum itself equals targetSum
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currentSum += node.val;
        int numPathsToCurr = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        int result = numPathsToCurr
                + dfs(node.left, currentSum, targetSum, prefixSumCount)
                + dfs(node.right, currentSum, targetSum, prefixSumCount);

        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return result;
    }

    public static void main(String[] args) {
        // Test case: root = [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000], targetSum = 0
        TreeNode root1 = new TreeNode(1000000000);
        root1.left = new TreeNode(1000000000);
        root1.left.left = new TreeNode(294967296);
        root1.left.left.left = new TreeNode(1000000000);
        root1.left.left.left.left = new TreeNode(1000000000);
        root1.left.left.left.left.left = new TreeNode(1000000000);
        PathSumIII solution = new PathSumIII();
        System.out.println(solution.pathSum(root1, 0)); // Expected output: 0

        // Test case: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(-3);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(2);
        root2.right.right = new TreeNode(11);
        root2.left.left.left = new TreeNode(3);
        root2.left.left.right = new TreeNode(-2);
        root2.left.right.right = new TreeNode(1);
        System.out.println(solution.pathSum(root2, 8)); // Expected output: 3

        // Test case: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(4);
        root3.right = new TreeNode(8);
        root3.left.left = new TreeNode(11);
        root3.right.left = new TreeNode(13);
        root3.right.right = new TreeNode(4);
        root3.left.left.left = new TreeNode(7);
        root3.left.left.right = new TreeNode(2);
        root3.right.right.left = new TreeNode(5);
        root3.right.right.right = new TreeNode(1);
        System.out.println(solution.pathSum(root3, 22)); // Expected output: 3
    }
}

