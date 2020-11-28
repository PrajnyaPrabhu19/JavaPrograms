package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
 * given a haystack and needle, finds a minimum window where needle is found
 * Haystack is array of String (here haystack is book)
 * Needle is array of String (here needle is set of words)
 * assuming the needle has distinct words
 * returns Minimum Window int []{left_pos, right_pos} : start and end positions of that window
 */

public class MinimumWindowInBook{

    public static int[] findMinWindow(String[] haystack, String[] needle){
        if(haystack == null || needle ==null){
            return null;
        }
        if(haystack.length==0 || needle.length==0){
            return null;
        }
        if(haystack.length<needle.length){
            return null;
        }
        //keep counts of interested words/needle
        Map<String, Integer> dict = new HashMap<>();
        for(int i=0;i<needle.length;i++){
            int count = dict.getOrDefault(needle[i], 0);
            dict.put(needle[i], count+1);
        }
        int reqSize = dict.size();
        int l=0, r=0; //right and left pointers.
        int formed = 0; // to track unique needle vals in the window.
        Map<String, Integer> windowCount = new HashMap<>(); // map to keep count of needles in the window
        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};
        while (r < haystack.length) {
            String curr = haystack[r];
            int count = windowCount.getOrDefault(curr, 0);
            windowCount.put(curr, count+1);
            if(dict.containsKey(curr)&& windowCount.get(curr)==dict.get(curr)){
                formed++;
            }
            //try to shorten the window
            while(l<=r && formed == reqSize){
                curr = haystack[l];
                //save smallest window
                if(ans[0]==-1 || r-l+1 <ans[0]){
                    ans[0] = r-l+1;
                    ans[1] =l;
                    ans[2] = r;
                }
                windowCount.put(curr , windowCount.get(curr)-1);
                if(dict.containsKey(curr) && windowCount.get(curr) <dict.get(curr)){
                    formed--;
                }
                l++; //shrink window
            }
            r++; //expand window
        }
        return ans;
    }

    public static void main(String[] args) {
        String book = "We consider a new data mining problem of detecting the" +
                " members of a rare class of data the needles that have been hidden in" +
                " a set of records the haystack Besides the haystack a single instance" +
                " of a needle is given It is assumed that members of the needle class are" +
                " similar according to an unknown needle characterization The goal is to" +
                " and the needle records hidden in the haystack This paper describes an" +
                " algorithm for that task and applies it to several test cases";

        String[] hayStack = book.split(" ");
        String[] needle = new String[]{"in", "haystack", "needle"};
        int[] result = findMinWindow(hayStack, needle);
        if(result ==null || result[0]==-1){
            System.out.println("Invalid input");
        }
        else{
            System.out.println("The start index is: "+result[1]+". The end index is: "+result[2]);
        }
    }
}