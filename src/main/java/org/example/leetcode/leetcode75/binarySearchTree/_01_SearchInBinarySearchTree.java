package org.example.leetcode.leetcode75.binarySearchTree;

//700. Search in a Binary Search Tree
//Solved
//Easy
//Topics
//Companies
//You are given the root of a binary search tree (BST) and an integer val.
//
//Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
//
//
//
//Example 1:
//
//
//Input: root = [4,2,7,1,3], val = 2
//Output: [2,1,3]
//Example 2:
//
//
//Input: root = [4,2,7,1,3], val = 5
//Output: []
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 5000].
//1 <= Node.val <= 10^7
//root is a binary search tree.
//1 <= val <= 10^7
public class _01_SearchInBinarySearchTree {

    // leetcode submit
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
    //done in below class
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class SearchInBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static void main(String[] args) {
        SearchInBST solution = new SearchInBST();

        // Example 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        int val1 = 2;
        TreeNode result1 = solution.searchBST(root1, val1);
        printTree(result1);

        // Example 2
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        int val2 = 5;
        TreeNode result2 = solution.searchBST(root2, val2);
        printTree(result2);
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        printTreeHelper(root, sb);
        sb.setLength(sb.length() - 2); // Remove the last comma and space
        sb.append("]");
        System.out.println(sb.toString());
    }

    private static void printTreeHelper(TreeNode node, StringBuilder sb) {
        if (node != null) {
            printTreeHelper(node.left, sb);
            sb.append(node.val).append(", ");
            printTreeHelper(node.right, sb);
        }
    }
}
