package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a
different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a
contiguous section all of the same character. Then for each group, say the number of characters, then say the character.
To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
Example 1:
Input: n = 1
Output: "1"
Explanation: This is the base case.

Example 2:
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

 */

public class CountandSay{

    public static String countAndSay(int n) {
        if(n==1){ return "1";}
        String ans = "1";
        for(int i = 2;i<=n;i++){
            ans = compute(ans);
        }
        return ans;
    }

    public static String compute(String s){
        char c = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<s.length();i++){
            if(c==s.charAt(i)){
                count++;
            }
            else{
                sb.append(count).append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Count and say 1: "+countAndSay(1));
        System.out.println("Count and say 4: "+countAndSay(4));
        System.out.println("Count and say 4: "+countAndSay(10));
    }
}