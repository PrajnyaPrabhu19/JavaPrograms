package com.main.programs;
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7]
            3
       9            20
  null   null     15   7

return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class LevelOrderTraversal{

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traverse=new ArrayList<List<Integer>>();
        if(root==null)return traverse;
        //BFS approach
        //create new queue to have BFS order of all nodes and after each level, add null
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        //At each level have an list to enter the values which will be added to final
        List<Integer> arr = new ArrayList<>();
        while(!q.isEmpty()){
            //get the first node from q
            TreeNode node = q.poll();
            if(node == null){
                traverse.add(arr);
                if(q.isEmpty()) break;
                arr = new ArrayList<>();
                q.add(null);
            }
            else{
                arr.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
        return traverse;
    }

    public static void main(String[] args) {
            TreeNode n4 = new TreeNode(15, null, null);
            TreeNode n5 = new TreeNode(7, null, null);
            TreeNode n3 = new TreeNode(20, n4, n5);
            TreeNode n2 = new TreeNode(9, null, null);
            TreeNode root = new TreeNode(3, n2, n3);

            List<List<Integer>> traversal = levelOrder(root);
            System.out.println("[");
            for(List<Integer> list: traversal){
                System.out.print("[");
                for(Integer i: list){
                    System.out.print(i+" ");
                }
                System.out.print("]");
                System.out.println("");
            }
        System.out.print("]");
        System.out.println("");
    }
}