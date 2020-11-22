package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Edit distance of two strings using Levenshtein distance algorithm.
 */

public class EditDistance{

    public static int minimum(int a, int b, int c){
        return Integer.min(a, Integer.min(b,c));
    }

    public static int editDistance(String x, String y){
        int m = x.length();
        int n = y.length();
        int[][] T = new int[m + 1][n + 1];
        //initialize the first column to value of i as it shows insertion cost
        for (int i = 1; i <= m; i++)
            T[i][0] = i;
        //initialize the first row to value of j as it shows deletion cost
        for (int j = 1; j <= n; j++)
            T[0][j] = j;

        int cost;
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (x.charAt(i-1) == y.charAt(j-1))
                    cost = 0;
                else
                    cost = 1;

                T[i][j] = minimum(T[i - 1][j] + 1,  // deletion
                        T[i][j - 1] + 1,            // insertion
                        T[i - 1][j - 1] + cost);    // replace
            }
        }
        return T[m-1][n-1];

    }

    public static void main(String[] args) {
        String x = "kitten";
        String y = "sitting";
        System.out.println("The edit distance of '"+x+"' and '"+y+"' is: "+editDistance(x,y));
    }
}