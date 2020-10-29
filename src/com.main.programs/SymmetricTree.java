package com.main.programs;
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
                    1
                 /      \
            2               2
          /   \           /   \
        3       4       3       4

But the following [1,2,2,null,3,null,3] is not.
 */


import java.io.*;
import java.util.*;
import java.lang.*;

public class SymmetricTree{

    public static class TreeNode {
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

    public static boolean isSymmetric(TreeNode root) {
        return isMirrorImage(root, root);
    }

    public static boolean isMirrorImage(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirrorImage(t1.right, t2.left) && isMirrorImage(t1.left, t2.right);
    }

    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(3, null, null);
        TreeNode n6 = new TreeNode(4, null, null);
        TreeNode n5 = new TreeNode(4, null, null);
        TreeNode n4 = new TreeNode(3, null, null);
        TreeNode n3 = new TreeNode(2, n6, n7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode root = new TreeNode(1, n2, n3);

        System.out.println("The tree is symmetric: "+ isSymmetric(root));
    }
}