package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Program that takes an array of numbers as  input and returns the length of longest nondecreasing subsequence in the array.
The elements of nondecreasing subsequence are not required to immediately follow each other in original sequence.
Example:
[0, 8, 4, 12, 2, 10, 6, 14, 1, 9]
The output is 4. There can be multiple subsequnces : [0, 4, 10, 14], [0, 2, 6, 9]..

Complexity: O(n2)
 */

public class LongestNonDecreasingSubsequence{

    public static int longestSubseq(int[] nums){
        if(nums==null || nums.length ==0){
            return -1;
        }
        if(nums.length==1){
            return 1;
        }
        int[] maxlen = new int[nums.length];
        Arrays.fill(maxlen,1);
        int max =1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>=nums[j]){
                    maxlen[i] = Math.max(maxlen[i], maxlen[j]+1);
                }
            }
            if(maxlen[i]>max){
                max=maxlen[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9};
        System.out.println("The longest non decreasing subsequence is:"+ longestSubseq(nums));
        int[] arr = new int[]{9, 6, 3};
        System.out.println("The longest non decreasing subsequence is:"+ longestSubseq(arr));
    }
}