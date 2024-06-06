package org.example.leetcode.dailyChallenges.may;

//2331. Evaluate Boolean Binary Tree
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given the root of a full binary tree with the following properties:
//
//Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
//Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
//The evaluation of a node is as follows:
//
//If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
//Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
//Return the boolean result of evaluating the root node.
//
//A full binary tree is a binary tree where each node has either 0 or 2 children.
//A leaf node is a node that has zero children.
//
//Example 1:
//Input: root = [2,1,3,null,null,0,1]
//Output: true
//Explanation: The above diagram illustrates the evaluation process.
//The AND node evaluates to False AND True = False.
//The OR node evaluates to True OR False = True.
//The root node evaluates to True, so we return true.
//
// Example 2:
//Input: root = [0]
//Output: false
//Explanation: The root node is a leaf node and it evaluates to false, so we return false.
//
//Constraints:
//The number of nodes in the tree is in the range [1, 1000].
//0 <= Node.val <= 3
//Every node has either 0 or 2 children.
//Leaf nodes have a value of 0 or 1.
//Non-leaf nodes have a value of 2 or 3.
public class _16_EvaluateBooleanBinaryTree {
    public static void main(String[] args) {
        _16_EvaluateBooleanBinaryTree obj = new _16_EvaluateBooleanBinaryTree();

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);
        root1.right.left = new TreeNode(0);
        boolean output1 = true;

        boolean flag1 = obj.evaluateBinaryTree(root1);
        System.out.println("Output for Example 1: " +flag1);

        TreeNode root2 = new TreeNode(0);
        boolean output2 = false;

        boolean flag2 = obj.evaluateBinaryTree(root2);
        System.out.println("Output for Example 1: " +flag2);


        if(flag1 == output1 && flag2 == output2)
            System.out.println("All tests are passing");
        else
            System.out.println("There are test failure");
    }

    public boolean evaluateBinaryTree(TreeNode root){
        if(root==null) return false;
        return evaluateBooleanBinaryTree(root);
    }

    public boolean evaluateBooleanBinaryTree(TreeNode node){
        if(node.left == null && node.right == null){ // leaf node
            return node.val == 1;
        } else if (node.val == 2) { // OR node
            assert node.left != null;
            return evaluateBooleanBinaryTree(node.left) || evaluateBooleanBinaryTree(node.right);
        } else if(node.val == 3) { // AND node
            assert node.left != null;
            return evaluateBooleanBinaryTree(node.left) && evaluateBooleanBinaryTree(node.right);
        } else {
            return false; // for invalid node value
        }
    }

    public boolean evaluateTree(TreeNode root) {

        if(root==null)
            return false;

        boolean first=evaluateTree(root.left);
        boolean second=evaluateTree(root.right);
        if(root.val==2)
            return first || second;
        else if(root.val==3)
            return first && second;
        else if(root.val==1)
            return true;
        else
            return false;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
