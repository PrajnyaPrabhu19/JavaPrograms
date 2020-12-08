package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Given a string, what is the minimum number of adjacent swaps required to convert a string into a palindrome.
If not possible, return -1.
Input: "mamad"
Output: 3
 */

public class MinSwapPalindrome{

    public static boolean canPalindrome(String s){
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            }
            else{
                set.add(s.charAt(i));
            }
        }
        if(set.size()>1){
            return false;
        }
        else{
            return true;
        }
    }

    private static void swap(char[] chars, int k, int i) {
        char temp = chars[k];
        chars[k] = chars[i];
        chars[i] = temp;
    }


    public static int minswap(String s){
        if(s==null || s.length()==0){
            return -1;
        }
        int l = s.length();
        if(l==1) return 0;
        boolean pal = canPalindrome(s);
        if(pal){
            int swaps = 0;
            char[] arr = s.toCharArray();
            int p=0, q= l-1;
            while(p<q){
                if(arr[p] == arr[q]){
                    p++;
                    q--;
                }
                else{
                    //p and qth chars not same, find a char at k to be swapped with q
                    int k =q;
                    while(k>p && arr[k]!= arr[p]){
                        k--;
                    }
                    //if the pth element should be the middle element;
                    if(k==p){
                        swap(arr, p, p+1);
                        swaps++;
                    }
                    else{
                        while(k<q){
                            swap(arr, k,k+1);
                            k++;
                            swaps++;
                        }
                        p++;q--;
                    }
                }
            }
            return swaps;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s1 = "dmama";
        String s2 = "abcdf";
        System.out.println("The minimum number of adjacent swaps required to convert a string '"+s1+"' to palindrome is: "+minswap(s1));
        System.out.println("The minimum number of adjacent swaps required to convert a string '"+s2+"' to palindrome is: "+minswap(s2));
    }
}