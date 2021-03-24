package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Given a string s, a k duplicate removal consists of choosing k (>=2) adjacent and equal letters from s and removing them
causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
 */

public class CandyCrush1D{

    public static class CharCount{
        char c;
        int v;

        public CharCount(char c, int v){
            this.c = c;
            this.v = v;
        }
        public void incCount(){
            this.v++;
        }
    }

    public static String crushString(String s, int k){
        if(s.length()<k) return s;
        Stack<CharCount> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(new CharCount(c,1));
            }
            else{
                int t = stack.peek().v;
                //check if current char is not equal
                if(stack.peek().c!=c){
                    //check if top element count is gt or eq to k
                    if(t>=k){
                        stack.pop();
                        //check if the below element is same
                        if(!stack.isEmpty() && stack.peek().c==c){
                            stack.peek().incCount();
                        }
                        else{
                            stack.push(new CharCount(c,1));
                        }
                    }
                    else{
                        stack.push(new CharCount(c,1));
                    }
                }
                else{
                    stack.peek().incCount();
                }
            }
        }
        //check at the end if the top element is greater than or eq to k
        if(stack.peek().v>=k){
            stack.pop();
        }
        //construct string to return
        String res = "";
        while(!stack.isEmpty()){
            int i = stack.peek().v;
            char r = stack.peek().c;
            while(i-- > 0){
                res=String.valueOf(r)+res;
            }
            stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaaa";

        int k = 3;
        System.out.println("The string after "+k+" crushing is: "+crushString(s,k));
    }
}