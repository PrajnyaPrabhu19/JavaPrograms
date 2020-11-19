package com.main.programs;

/*
Check if the list is palindrome using O(1) space and O(n) time complexity.
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class ListPalindrome{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
        ListNode(int x, ListNode head){
            this.val = x;
            this.next = head;
        }
    }

    public static ListNode reverse(ListNode sub){
        if(sub==null ||sub.next==null){
            return sub;
        }

        ListNode dum = new ListNode(0);
        dum.next = sub;
        ListNode it = sub;
        sub = dum;
        while(it.next!=null){
            ListNode t = it.next;
            it.next = t.next;
            t.next = sub.next;
            sub.next=t;
        }
        return sub.next;
    }

    public static boolean checkPalindrome(ListNode h){
        if(h==null || h.next==null){
            return true;
        }
        //find the mid point
        ListNode slow = h;
        ListNode fast =h;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast =fast.next.next;
        }
        //fast = null even length, slow pointing at start of next half and fast.next=null then odd length list slow pointing at mid element of list
        if(fast== null){
            ListNode ptr = reverse(slow);
            slow = ptr;
        }
        else{
            ListNode ptr = reverse(slow.next);
            slow = ptr;
        }

        ListNode check = h;
        while(slow!=null){
            if(check.val!=slow.val){
                return false;
            }
            slow=slow.next;
            check = check.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode h1 = n1;
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next =n2;
        n2.next =n3;
        n3.next =n4;
        ListNode p=h1;
        while(p.next!=null){
            System.out.print(p.val+"->");
            p=p.next;
        }
        System.out.print(p.val);
        System.out.println("  The list is palindrome: "+checkPalindrome(h1));

        ListNode n5 = new ListNode(1);
        ListNode h2 = n5;
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(3);
        ListNode n8 = new ListNode(1);
        n5.next =n6;
        n6.next =n7;
        n7.next =n8;
        p=h2;
        while(p.next!=null){
            System.out.print(p.val+"->");
            p=p.next;
        }
        System.out.print(p.val);
        System.out.println("  The list is palindrome: "+checkPalindrome(h2));

        ListNode m5 = new ListNode(1);
        ListNode h3 = m5;
        ListNode m6 = new ListNode(2);
        ListNode m7 = new ListNode(3);
        ListNode m8 = new ListNode(2);
        ListNode m9 = new ListNode(1);
        m5.next =m6;
        m6.next =m7;
        m7.next =m8;
        m8.next =m9;
        p=h3;
        while(p.next!=null){
            System.out.print(p.val+"->");
            p=p.next;
        }
        System.out.print(p.val);
        System.out.println("  The list is palindrome: "+checkPalindrome(h3));
    }
}