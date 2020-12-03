package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.

Ex:
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
 */

public class CompareVersionNumbers{

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < v1.length && j < v2.length) {
            int a = Integer.parseInt(v1[i]);
            int b = Integer.parseInt(v2[i]);
            if (a > b) {
                return 1;
            } else if (b > a) {
                return -1;
            }
            i++;
            j++;
        }
        while (i < v1.length) {
            int a = Integer.parseInt(v1[i++]);
            if (a != 0) {
                return 1;
            }
        }
        while (j < v2.length) {
            int b = Integer.parseInt(v2[j++]);
            if (b != 0) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("version1 is greater than version2: "+ compareVersion("0.1", "1.1"));
        System.out.println("version1 is greater than version2: "+ compareVersion("1.1.0", "1.1"));
        System.out.println("version1 is greater than version2: "+ compareVersion("2.1", "1.1"));
    }
}