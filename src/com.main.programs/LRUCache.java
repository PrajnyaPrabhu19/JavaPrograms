package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
implement the lru cache using doubly linked list and hashmap
 */

public class LRUCache{

    public static class doublyLinkedNode{
        int val;
        int key;
        doublyLinkedNode prev;
        doublyLinkedNode next;
        doublyLinkedNode() {}
        doublyLinkedNode(int k, int v){
            this.val = v;
            this.key = k;
        }
    }

    public static class LRU{
        private doublyLinkedNode head;
        private doublyLinkedNode tail;
        private HashMap<Integer, doublyLinkedNode> map;
        private int capacity, count;

        public LRU(int capacity){
            this.capacity =capacity;
            map = new HashMap<>();
            head = new doublyLinkedNode(0,0);
            tail = new doublyLinkedNode(0,0);
            head.prev=null;
            head.next =tail;
            tail.prev=head;
            tail.next =null;
            this.count =0;
        }

        public int get(int key){
            if(map.containsKey(key)){
                doublyLinkedNode node = map.get(key);
                return node.val;
            }
            else{
                return -1;
            }
        }

        public void delete(doublyLinkedNode node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        public void addToHead(doublyLinkedNode node){
            head.next.prev = node;
            node.next = head.next;
            head.next =node;
            node.prev =head;
        }

        public void set(int k, int v){
            if(map.get(k)!=null){
                doublyLinkedNode node =map.get(k);
                delete(node); //remove from the chache to change the order
                addToHead(node); //add it to head
            }
            else{
                doublyLinkedNode node = new doublyLinkedNode(k,v);
                map.put(k,node);
                if(count<capacity){
                    addToHead(node);
                    count++;
                }
                else{
                    int dnode_k = tail.prev.key;
                    map.remove(dnode_k);
                    delete(tail.prev);
                    addToHead(node);
                }
            }
        }

    }

    public static void printval(int v, LRU cache){
        int val = cache.get(v);
        if(val==-1){
            System.out.println("The key was not present in the cache");
        }
        else {
            System.out.println("The value of key " + v + " is: " + val);
        }
    }

    public static void main(String[] args) {
        LRU cache =new LRU(2);
        cache.set(1,10);
        cache.set(2,20);
        printval(1,cache);
        cache.set(3,30);
        cache.set(4,30);
        printval(2, cache);
    }
}