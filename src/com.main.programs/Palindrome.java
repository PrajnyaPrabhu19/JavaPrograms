package com.main.programs;

/*
Using HashSet determine if a string can be a palindrome by rearranging the letters
 */
import java.io.*;
import java.util.*;
import java.lang.*;

public class Palindrome{

    public static boolean canPalindrome(String s){
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            }
            else{
                set.add(s.charAt(i));
            }
        }
        if(set.size()>1){
            return false;
        }
        else{
            return true;
        }
    }
    public static void main(String[] args) {
        String s = "level";
        System.out.println("String '"+s+"' can be palindrome: "+canPalindrome(s));
        System.out.println("String 'boolean' can be a palindrome: "+canPalindrome("boolean"));
        System.out.println("String 'boomsberers' can be a palindrome: "+canPalindrome("boomsberers"));
    }
}