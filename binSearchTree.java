//Course: CSCI 230
//        Name: Ben Hairston
//        Homework Assignment 6
//        Problem 6: Leetcode 98- Validate Binary Search Tree
//        Data Structure and Algorithm: Binary Search Tree



public class binSearchTree {
    public boolean helper(TreeNode node, long  min, long max){
        if(node == null){
            return true;
        }
        if(node.val <= min || max <= node.val){
            return false;
        }
        return helper(node.left, min, node.val) && helper(node.right,node.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

