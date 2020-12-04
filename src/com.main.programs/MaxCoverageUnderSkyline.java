package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
You are given a sequence of adjacent buildings. Each has unit width and integer heught.
These buildings form the skyline of the city. An architect wants to know the area of the largest rectangle contained in the
skyline.
Thsi problem is similar to the largest rectangle in a histogram problem.

Input = [2, 3, 1, 4, 2]
Output = 5 (height =1; width = 5)
 */

public class MaxCoverageUnderSkyline{

    public static class Result{
        int height;
        int width;
        int area;

        public Result(int height, int width, int area){
            this.height = height;
            this.width = width;
            this.area = area;
        }

        public void setNewDims(int height, int width, int area){
            this.height = height;
            this.width = width;
            this.area = area;
        }
    }

    public static Result largestRectangle(int[] heights){
        Result res = new Result(0,0,0);
        if(heights==null|| heights.length==0){
            return res;
        }
        int max =0;
        int i=0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (i<heights.length){
            if(stack.isEmpty() || heights[i]>=heights[stack.peek()] ){
                stack.push(i);
                i++;
            }
            else{
                int p= stack.pop();
                int h= heights[p];
                int width = (stack.isEmpty() ? i : stack.peek()-1);
                int area = h*width;
                if(area>max){
                    res.setNewDims(h, width, area);
                }
            }
        }
        while (!stack.isEmpty()){
            int p= stack.pop();
            int h= heights[p];
            int width = (stack.isEmpty() ? i : stack.peek()-1);
            int area = h*width;
            if(area>max){
                res.setNewDims(h, width, area);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = new int[] {2, 3, 1, 4, 2};
        Result res = largestRectangle(heights);
        System.out.println("The largest area under skyline is: "+res.area);
        System.out.println("The height is: "+res.height);
        System.out.println("The width is: "+res.width);
    }
}