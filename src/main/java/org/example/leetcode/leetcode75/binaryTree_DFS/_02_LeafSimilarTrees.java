package org.example.leetcode.leetcode75.binaryTree_DFS;

import java.util.ArrayList;
import java.util.List;

//872. Leaf-Similar Trees
//Solved
//Easy
//Topics
//Companies
//Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
//
//
//
//For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
//Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
//Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//
//
//
//Example 1:
//
//
//Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
//Output: true
//Example 2:
//
//
//Input: root1 = [1,2,3], root2 = [1,3,2]
//Output: false
//
//
//Constraints:
//
//The number of nodes in each tree will be in the range [1, 200].
//Both of the given trees will have values in the range [0, 200].
public class _02_LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }
}
class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder leaves1 = new StringBuilder();
        StringBuilder leaves2 = new StringBuilder();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        return leaves1.toString().equals(leaves2.toString());
    }

    private void getLeaves(TreeNode root, StringBuilder leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.append(root.val).append(",");
        }
        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }

    public static void main(String[] args) {
        LeafSimilarTrees solution = new LeafSimilarTrees();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.right = new TreeNode(4);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        System.out.println(solution.leafSimilar(root1, root2)); // Output: true

        // Example 2
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(3);
        root4.right = new TreeNode(2);

        System.out.println(solution.leafSimilar(root3, root4)); // Output: false
    }
}

