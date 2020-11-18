package com.main.programs;

/*
Given a list of integers, return the smallest non constructible value.
For example List = {1,2,2,4,12,14}
smallest non constructible value is 10.
As possible values are: {1}, {2}, {1+2}, {2+2/4}, {4+1}, {2+4}, {4+2+1}, {4+2+2}, {1+2+2+4},{12},{1+12},...
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class NonConstructible{

    public static int smallNonConstVal(List<Integer> A){
        int max=0;
        for(int a : A){
            if(a>max+1){
                break;
            }
            max+=a;
        }
        return max+1;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1); A.add(2); A.add(2); A.add(4);
        A.add(12); A.add(13);
        System.out.println("Smallest non constructible value: "+ smallNonConstVal(A));
    }
}