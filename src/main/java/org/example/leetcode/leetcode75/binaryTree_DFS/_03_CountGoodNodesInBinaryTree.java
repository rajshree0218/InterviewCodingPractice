package org.example.leetcode.leetcode75.binaryTree_DFS;

//1448. Count Good Nodes in Binary Tree
//Solved
//Medium
//Topics
//Companies
//Hint
//Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
//
//Return the number of good nodes in the binary tree.
//
//
//
//Example 1:
//
//
//
//Input: root = [3,1,4,3,null,1,5]
//Output: 4
//Explanation: Nodes in blue are good.
//Root Node (3) is always a good node.
//Node 4 -> (3,4) is the maximum value in the path starting from the root.
//Node 5 -> (3,4,5) is the maximum value in the path
//Node 3 -> (3,1,3) is the maximum value in the path.
//Example 2:
//
//
//
//Input: root = [3,3,null,4,2]
//Output: 3
//Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
//Example 3:
//
//Input: root = [1]
//Output: 1
//Explanation: Root is considered as good.
//
//
//Constraints:
//
//The number of nodes in the binary tree is in the range [1, 10^5].
//Each node's value is between [-10^4, 10^4].
public class _03_CountGoodNodesInBinaryTree {

    // leetcode
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }

        int good = 0;
        if (node.val >= maxVal) {
            good = 1;
            maxVal = node.val;
        }

        good += dfs(node.left, maxVal);
        good += dfs(node.right, maxVal);

        return good;
    }
}

class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode root, int maxSoFar) {
        if (root == null) {
            return 0;
        }
        int count = root.val >= maxSoFar ? 1 : 0;
        maxSoFar = Math.max(maxSoFar, root.val);
        count += countGoodNodes(root.left, maxSoFar);
        count += countGoodNodes(root.right, maxSoFar);
        return count;
    }

    public static void main(String[] args) {
        CountGoodNodes solution = new CountGoodNodes();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(3);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(5);
        System.out.println(solution.goodNodes(root1)); // Output: 4

        // Example 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(2);
        System.out.println(solution.goodNodes(root2)); // Output: 3

        // Example 3
        TreeNode root3 = new TreeNode(1);
        System.out.println(solution.goodNodes(root3)); // Output: 1
    }
}
