package org.example.leetcode.leetcode75.binaryTree_DFS;

//104. Maximum Depth of Binary Tree
//Solved
//Easy
//Topics
//Companies
//Given the root of a binary tree, return its maximum depth.
//
//A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
//Example 2:
//
//Input: root = [1,null,2]
//Output: 2
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 104].
//-100 <= Node.val <= 100
public class _01_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        MaxDepth solution = new MaxDepth();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.maxDepth(root1)); // Output: 3

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println(solution.maxDepth(root2)); // Output: 2
    }
}
