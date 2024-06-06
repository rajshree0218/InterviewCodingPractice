package org.example.leetcode.leetcode75.binaryTree_DFS;

//1372. Longest ZigZag Path in a Binary Tree
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given the root of a binary tree.
//
//A ZigZag path for a binary tree is defined as follow:
//
//Choose any node in the binary tree and a direction (right or left).
//If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
//Change the direction from right to left or from left to right.
//Repeat the second and third steps until you can't move in the tree.
//Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
//
//Return the longest ZigZag path contained in that tree.
//
//
//
//Example 1:
//
//
//Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
//Output: 3
//Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
//Example 2:
//
//
//Input: root = [1,1,1,null,1,null,null,1,1,null,1]
//Output: 4
//Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
//Example 3:
//
//Input: root = [1]
//Output: 0
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 5 * 104].
//1 <= Node.val <= 100
public class _05_LongestZigZagPathInBinaryTree {
    //leetcode
    private int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root.left, true, 1);
        dfs(root.right, false, 1);

        return maxZigZag;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) {
            return;
        }

        maxZigZag = Math.max(maxZigZag, length);

        if (isLeft) {
            dfs(node.right, false, length + 1);
            dfs(node.left, true, 1);
        } else {
            dfs(node.left, true, length + 1);
            dfs(node.right, false, 1);
        }
    }
}

class LongestZigZagPath {
    int maxLen;

    public int longestZigZag(TreeNode root) {
        maxLen = 0;
        findLongestZigZag(root.left, true, 1); // left child with initial direction left
        findLongestZigZag(root.right, false, 1); // right child with initial direction right
        return maxLen;
    }

    private void findLongestZigZag(TreeNode node, boolean isLeft, int len) {
        if (node == null) {
            return;
        }
        maxLen = Math.max(maxLen, len);
        if (isLeft) {
            findLongestZigZag(node.right, false, len + 1); // move right
            findLongestZigZag(node.left, true, 1); // restart from left
        } else {
            findLongestZigZag(node.left, true, len + 1); // move left
            findLongestZigZag(node.right, false, 1); // restart from right
        }
    }

    public static void main(String[] args) {
        LongestZigZagPath solution = new LongestZigZagPath();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(1);
        root1.right.left.left = new TreeNode(1);
        root1.right.right.right = new TreeNode(1);
        int longestZigZag1 = solution.longestZigZag(root1);
        System.out.println(longestZigZag1); // Output: 3

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(1);
        root2.right.right = new TreeNode(1);
        root2.left.right.left = new TreeNode(1);
        int longestZigZag2 = solution.longestZigZag(root2);
        System.out.println(longestZigZag2); // Output: 4

        // Example 3
        TreeNode root3 = new TreeNode(1);
        int longestZigZag3 = solution.longestZigZag(root3);
        System.out.println(longestZigZag3); // Output: 0
    }
}
