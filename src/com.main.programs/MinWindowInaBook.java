package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*

 ********!!!!  THIS CODE WAS SHARED BY MY INTERVIEWER  !!!!********

   * given a haystack and needle, finds a minimum window where needle is found
   * Haystack is array of String (here haystack is book)
   * Needle is array of String (here needle is set of words)
   * assuming the needle has distinct words
   * returns Minimum Window int []{left_pos, right_pos} : start and end positions of that window
 */

public class MinWindowInaBook {

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
                    // System.out.println(Arrays.toString(hayStack));
                    int result[] = findMinWindow(hayStack, needle);
                    if(result != null)
                         System.out.println(result[0] + " to " + result[1]);
                     else {
                         System.out.println("Input is Wrong");
                       }
              }

     private static int[] findMinWindow(String[] hayStack, String[] needle) {

         if(hayStack == null || needle == null)
             return null;
         if(hayStack.length == 0 || needle.length == 0)
             return null;
         if(hayStack.length < needle.length)
             return null;

         // current left and right indexes
         int leftIndex = -1;
         int rightIndex = -1;
         // minimum and max indices found so for
         int minIndex = -1;
         int maxIndex = -1;
         // for storing the found words
         int totalFound = 0;
         // this holds the
         TreeMap<String, Integer> found = new TreeMap<>();
         TreeMap<String, Integer> target = new TreeMap<>();
         for(String str : needle) {
             if(target.containsKey(str))
                 target.put(str, target.get(str) + 1);
             else
                 target.put(str, 1);
             // init found with zero ..
             // this removes lot of null checking in code
             found.put(str, 0);
         }
         System.out.println("We want to find " + target);
         System.out.println("currently found " + found);
         // pointing to current string
         String curr = new String();
         while(true) {
             if(totalFound < needle.length) {
                 rightIndex++;
                 if(rightIndex == hayStack.length)
                     break;
                 curr = hayStack[rightIndex];
                 if((target.containsKey(curr))) {
                     if(found.get(curr) < target.get(curr)) {
                         totalFound++;
                     }
                     found.put(curr, found.get(curr) + 1);
                 }
                  System.out.println(totalFound + " " + found);
             }
             else {
                 if(totalFound == needle.length) {
                     if(minIndex == -1 || (maxIndex - minIndex) > (rightIndex - leftIndex - 1)) {
                         minIndex = leftIndex + 1;
                         maxIndex = rightIndex;
                     }
                     System.out.println((leftIndex+1) + "," + rightIndex);
                 }
                 leftIndex++;
                 curr = hayStack[leftIndex];
                 if((target.containsKey(curr))) {
                     if(found.get(curr) <= target.get(curr)) {
                         totalFound--;
                     }
                     found.put(curr, found.get(curr) - 1);
                 }
             }
         }
         return new int[]{minIndex, maxIndex};
     }
 }