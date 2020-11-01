package com.main.programs;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class LinkedListCycle{

    public static boolean hasCycle(ListNode head){
        if(head==null || head.next==null) return false;
        ListNode p,q;
        p=head.next;
        q=head;
        while(p!=q){
            if(p==null||p.next==null){
                return false;
            }
            p=p.next.next;
            q=q.next;
        }
        return true;
    }

    public static void main(String[] args) {
        //create a cyclic ll
        ListNode n1 = new ListNode(3);
        ListNode h1 = n1;
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        System.out.printl("List1 has cycle: "+hasCycle(h1));

        //create a list with no cycle
        ListNode n5 = new ListNode(3);
        ListNode h2 = n5;
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(0);
        ListNode n8 = new ListNode(4);
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        System.out.printl("List1 has cycle: "+hasCycle(h2));
    }
}