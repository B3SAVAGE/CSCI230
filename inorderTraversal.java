//Course: CSCI 230
//        Name: Ben Hairston
//        Homework Assignment 6
//        Problem 6: Leetcode 94- Inorder Traversal
//        Data Structure and Algorithm: Binary Search Tree


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }


 class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;

        while(root != null || stack.size() > 0){
            if(root!= null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }

        }
        return list;
    }
}

