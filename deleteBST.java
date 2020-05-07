//Course: CSCI 230
//        Name: Ben Hairston
//        Homework Assignment 6
//        Problem 1.1: Leetcode 450 - Delete BST
//        Data Structure and Algorithm: Binary Search Tree
package Completed;

public class deleteBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

}

