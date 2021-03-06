package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer,
which may or may not point to a separate doubly linked list. These child lists may have one or more children of their
own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the
first level of the list.
Example:
Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 */

public class FlattenMultilevelList{

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val){
            this.val = val;
            this.next =null;
            this.prev =null;
            this.child = null;
        }
    }

    public static Node flatten(Node head){
        if(head==null) return head;
        Stack<Node> stack = new Stack<>();
        Node cur =head;
        Node next = cur.next;
        while(cur!=null || !stack.isEmpty()){
            if(cur.child!=null){
                next = cur.next;
                if(next!=null){
                    stack.push(next);
                }
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            }
            if(cur.next == null && !stack.isEmpty()){
                cur.next = stack.pop();
                cur.next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node c1 = new Node(4);
        Node c2 = new Node(5);
        n1.next = n2;
        n2.next = n3;
        n2.child = c1;
        c1.next = c2;
        n2.prev =n1;
        c2.prev = c1;
        n3.prev = n2;
        Node head = flatten(n1);
        while(head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.print("null");
    }
}