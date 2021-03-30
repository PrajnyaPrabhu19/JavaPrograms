package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes
first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Follow up: What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

public class AddTwoNumbers{

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; this.next=null; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addNums(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1= l1.next;
        }
        while(l2!= null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = null;
        int carry =0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            int sum = carry;
            if(!s1.isEmpty()){
                sum+=s1.pop();
            }
            if(!s2.isEmpty()){
                sum+=s2.pop();
            }
            carry = sum/10;
            sum = sum%10;
            s3.push(sum);
        }
        while(!s3.isEmpty()){
            ListNode n = new ListNode(s3.pop());
            n.next = res;
            res = n;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode k1 = new ListNode(5);
        ListNode k2 = new ListNode(6);
        ListNode k3 = new ListNode(4);
        l1.next = l2; l2.next= l3; l3.next = l4;
        k1.next = k2; k2.next = k3;
        ListNode r = addNums(l1, k1);
        while(r!=null){
            System.out.print(r.val+"->");
            r = r.next;
        }
        System.out.print("null");
    }
}