package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string.
For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

Example:
Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
 */

public class UniqueCharFrequency{

    public static int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int v = map.get(c);
                map.put(c, v+1);
            }
            else{
                map.put(c, 1);
            }
        }
        int del =0;
        Map<Integer, Character> res = new HashMap<>();
        for(char key : map.keySet()){
            int val = map.get(key);
            while(res.containsKey(val)){
                val=val-1;
                del+=1;;
            }
            if(val!=0){
                res.put(val, key);
            }
        }
        return del;
    }

    public static void main(String[] args) {
        String s1 = "aaabbbcc";
        String s2 = "aab";
        System.out.println("The number of deletions required to make string '"+s1+"' good is: "+minDeletions(s1));
        System.out.println("The number of deletions required to make string '"+s2+"' good is: "+minDeletions(s2));
    }
}