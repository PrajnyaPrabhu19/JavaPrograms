package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Write a program which takes as input an integer array and returns the pair of entries that trap the maximum amount of water.
Ex:
Input = [1, 2, 1, 3, 4, 4, 5, 6, 2, 1, 3, 1, 3,  2, 1, 2, 4, 1]
Output: 4, 16 and maxwater = 48
 */

public class MaxTrappedWater{

    public static class Result{
        int left;
        int right;
        int maxWater;
        int height;
        public Result(int left, int right,int height, int maxWater){
            this.left = left;
            this.right = right;
            this.height = height;
            this.maxWater = maxWater;
        }
    }

    public static Result maxWater(int[] heights){
        int i =0, j = heights.length-1, maxWater =0;
        Result res = new Result(0,0,0,0);
        while(i<j){
            int width = j-i;
            int height = Math.min(heights[i], heights[j]);
            int waterTrapped = width * height;
            if(waterTrapped>maxWater){
                res = new Result(i,j,height,waterTrapped);
                maxWater = waterTrapped;
            }
            if(heights[i]>heights[j]){
                --j;
            }
            else{
                ++i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1, 2, 1, 3, 4, 4, 5, 6, 2, 1, 3, 1, 3,  2, 1, 2, 4, 1};
        Result res = maxWater(heights);
        System.out.println("The start index: "+ res.left+" and the end index: "+res.right);
        System.out.println("The height of the wall: "+res.height+" and the max water trapped: "+res.maxWater);
    }

}