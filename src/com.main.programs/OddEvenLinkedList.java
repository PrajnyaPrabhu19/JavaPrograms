package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
Example:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
 */

public class OddEvenLinkedList{

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if((head ==null) || (head.next==null) || (head.next.next == null)){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        while(even!=null && even.next!=null ){
            ListNode tmp = even.next;
            even.next = tmp.next;
            tmp.next = odd.next;
            odd.next =tmp;
            odd=odd.next;
            even = even.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode m5 = new ListNode(1);
        ListNode h3 = m5;
        ListNode m6 = new ListNode(2);
        ListNode m7 = new ListNode(3);
        ListNode m8 = new ListNode(4);
        ListNode m9 = new ListNode(5);
        m5.next =m6;
        m6.next =m7;
        m7.next =m8;
        m8.next =m9;

        ListNode p=h3;
        System.out.print("Input:");
        while(p.next!=null){
            System.out.print(p.val+"->");
            p=p.next;
        }
        System.out.print(p.val+"\n");

        h3 = oddEvenList(h3);
        p=h3;
        System.out.print("Output:");
        while(p.next!=null){
            System.out.print(p.val+"->");
            p=p.next;
        }
        System.out.print(p.val+"\n");

    }
}