package org.example.leetcode.leetcode75.binaryTree_BFS;

//199. Binary Tree Right Side View
//Solved
//Medium
//Topics
//Companies
//Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//
//
//Example 1:
//
//
//Input: root = [1,2,3,null,5,null,4]
//Output: [1,3,4]
//Example 2:
//
//Input: root = [1,null,3]
//Output: [1,3]
//Example 3:
//
//Input: root = []
//Output: []
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 100].
//-100 <= Node.val <= 100

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _01_BinaryTreeRightSideView {
}

class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RightSideView solution = new RightSideView();

        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        System.out.println(solution.rightSideView(root1)); // Output: [1, 3, 4]

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println(solution.rightSideView(root2)); // Output: [1, 3]

        // Example 3
        TreeNode root3 = null;
        System.out.println(solution.rightSideView(root3)); // Output: []
    }
}

