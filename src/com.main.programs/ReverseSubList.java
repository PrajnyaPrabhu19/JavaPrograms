package com.main.programs;

/*
Given a linked list L, and start and finish of sublist within L, reverse the sublist.
For example if L = 1->2->3->4->5->6, start = 2, finish = 5 then the result should be L= 1->5->4->3->2->6
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class ReverseSubList{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseList(ListNode L, int start, int finish){
        if(L==null){
            return L;
        }
        if(start==finish){
            return L;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = L;
        int k =1;
        ListNode subList = dummy;
        while(k++<start){
            subList=subList.next;
        }
        ListNode sublistIterator = subList.next;
        while (start++<finish){
            ListNode temp = sublistIterator.next;
            sublistIterator.next = temp.next;
            temp.next = subList.next;
            subList.next = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode h1 = n1;
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next =n2;
        n2.next =n3;
        n3.next =n4;
        n4.next =n5;
        n5.next =n6;
        ListNode p =h1;
        while(p!=null && p.next!=null){
            System.out.print(p.val+"->");
            p=p.next;
        }
        System.out.print(p.val);

        System.out.println("\nReverse List");
        h1 = reverseList(h1, 2,5);
        p =h1;
        while(p!=null && p.next!=null){
            System.out.print(p.val+"->");
            p=p.next;
        }
        System.out.print(p.val);
        System.out.println("");
    }

}