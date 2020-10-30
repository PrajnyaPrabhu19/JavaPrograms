package com.main.programs;
/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class PascalTriangle{

    public static List<List<Integer>> generatePascalT(int numRows){
        List<List<Integer>> tri = new ArrayList<List<Integer>>();
        if(numRows == 0) return tri;

        //first row is always 1
        tri.add(new ArrayList<>());
        tri.get(0).add(1);

        for(int row =1; row< numRows; row++){
            List<Integer> r = new ArrayList<>();
            List<Integer> prev = tri.get(row-1);

            //first element and last element of the row is always 1
            r.add(1);

            for(int j=1;j<row;j++){
                r.add(prev.get(j-1) + prev.get(j));
            }
            //the last element
            r.add(1);
            tri.add(r);
        }
        return tri;
    }

    public static void main(String[] args) {
        //input numRows
        int numRows = 5;

        List<List<Integer>> pascal = generatePascalT(numRows);

        System.out.println("[");
        for(List<Integer> rows: pascal){
            System.out.print("[");
            for(Integer i: rows){
                System.out.print(i+" ");
            }
            System.out.print("]");
            System.out.println("");
        }
        System.out.print("]");
    }
}