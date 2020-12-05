package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Write a program for finding a minimum set of numbers that covers all the intervals.
Ex: Given = [0,3],[2,6], [3,4], [6,9]. Output = [3,6]
 */

public class MinPointsCoveringIntervals{

    public static class Interval{
        public int left, right;
        public Interval(int l, int r){
            this.left = l;
            this.right =r;
        }
    }

    public static List<Integer> findMinVisit(List<Interval> intervals){
        //sort the listin ascending order of the right interval value
        intervals.sort((i1,i2)-> Integer.compare(i1.right, i2.right));
        List<Integer> res = new ArrayList<>();
        int lastVisitTime = Integer.MIN_VALUE;
        for(Interval i: intervals){
            if(i.left > lastVisitTime){
                //new interval encountered; add the right value of this to list
                res.add(i.right);
                lastVisitTime = i.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(3,4));
        intervals.add(new Interval(6,9));
        List<Integer> res = findMinVisit(intervals);
        System.out.println("The min number that covers all intervals is: "+res.size());
        System.out.println("The visit times are: ");
        for(int i: res){
            System.out.println(i);
        }
    }
}