package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
A linked list of length n is given such that each node contains an additional random pointer,which could point to any
node in the list, or null.
Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its
value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point
to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
None of the pointers in the new list should point to nodes in the original list.
For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two
nodes x and y in the copied list, x.random --> y.
 */

public class CopyRandomList{
    public static class Node {
         int val;
         Node next;
         Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        Node dummy = new Node(0);
        Node curCopy = dummy;
        Node cur = head;
        while(cur!=null){
            if(nodeMap.containsKey(cur)){
                curCopy.next = nodeMap.get(cur);
            }
            else{
                Node newcopy = new Node(cur.val);
                curCopy.next = newcopy;
                nodeMap.put(cur,newcopy);
            }
            curCopy = curCopy.next;

            if(cur.random!=null){
                if(nodeMap.containsKey(cur.random)){
                    curCopy.random = nodeMap.get(cur.random);
                }
                else{
                    Node random = new Node(cur.random.val);
                    curCopy.random = random;
                    nodeMap.put(cur.random, random);
                }
            }
            cur=cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        head.random = n4;
        n2.random = n3;
        n3.random = head;
        n4.random = n2;
        Node nH = copyRandomList(head);

        while(nH!=null){
            System.out.println("["+nH.val+","+nH.random.val+"] ");
            nH= nH.next;
        }
    }
}