package com.main.programs;

/*
Given a linked list L, and start and finish of sublist within L, reverse the sublist.
For example if L = 1->2->3->4->5->6, start = 2, finish = 5 then the result should be L= 1->5->4->3->2->6
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public static class ReverseSubList{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode h1 = n1;
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);


    }

}