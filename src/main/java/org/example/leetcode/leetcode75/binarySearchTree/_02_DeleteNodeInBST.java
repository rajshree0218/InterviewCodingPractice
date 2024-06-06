package org.example.leetcode.leetcode75.binarySearchTree;

//450. Delete Node in a BST
//Solved
//Medium
//Topics
//Companies
//Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
//
//Basically, the deletion can be divided into two stages:
//
//Search for a node to remove.
//If the node is found, delete the node.
//
//
//Example 1:
//
//
//Input: root = [5,3,6,2,4,null,7], key = 3
//Output: [5,4,6,2,null,null,7]
//Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
//One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
//Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
//
//Example 2:
//
//Input: root = [5,3,6,2,4,null,7], key = 0
//Output: [5,3,6,2,4,null,7]
//Explanation: The tree does not contain a node with value = 0.
//Example 3:
//
//Input: root = [], key = 0
//Output: []
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [0, 104].
//-10^5 <= Node.val <= 10^5
//Each node has a unique value.
//root is a valid binary search tree.
//-10^5 <= key <= 10^5
//
//
//Follow up: Could you solve it with time complexity O(height of tree)?s
public class _02_DeleteNodeInBST {

    // leetcode submit
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode successor = findSuccessor(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    private TreeNode findSuccessor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}

class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with key found
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children
            root.val = findMin(root.right).val;
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        DeleteNodeInBST solution = new DeleteNodeInBST();

        // Example 1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(7);
        int key1 = 3;
        TreeNode result1 = solution.deleteNode(root1, key1);
        printTree(result1);

        // Example 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        int key2 = 0;
        TreeNode result2 = solution.deleteNode(root2, key2);
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

