package org.example.leetcode.leetcode75.binaryTree_DFS;

//236. Lowest Common Ancestor of a Binary Tree
//Solved
//Medium
//Topics
//Companies
//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
//
//
//Example 1:
//
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
//Example 2:
//
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
//Example 3:
//
//Input: root = [1,2], p = 1, q = 2
//Output: 1
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [2, 105].
//-109 <= Node.val <= 109
//All Node.val are unique.
//p != q
//p and q will exist in the tree.
public class _06_LowestCommonAncestorOfBinaryTree {
    // leetcode
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }
}

class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
        LowestCommonAncestor solution = new LowestCommonAncestor();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        TreeNode lca1 = solution.lowestCommonAncestor(root1, root1.left, root1.right);
        System.out.println(lca1.val); // Output: 3

        // Example 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(2);
        root2.right.left = new TreeNode(0);
        root2.right.right = new TreeNode(8);
        root2.left.right.left = new TreeNode(7);
        root2.left.right.right = new TreeNode(4);
        TreeNode lca2 = solution.lowestCommonAncestor(root2, root2.left, root2.left.right.right);
        System.out.println(lca2.val); // Output: 5

        // Example 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        TreeNode lca3 = solution.lowestCommonAncestor(root3, root3, root3.left);
        System.out.println(lca3.val); // Output: 1
    }
}
