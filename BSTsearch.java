//Course: CSCI 230
//        Name: Ben Hairston
//        Homework Assignment 6
//        Problem 1.1: Leetcode 700 - Search BST
//        Data Structure and Algorithm: Binary Search Tree
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode left_node = searchBST(root.left, val);

        if (left_node != null) {
            return left_node;
        }

        return searchBST(root.right, val);
    }
}
