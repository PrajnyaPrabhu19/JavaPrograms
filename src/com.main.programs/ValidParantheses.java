package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Input: s = "()[]{}"
Output: true
 */

public class ValidParantheses{

    public static boolean isValid(String s) {
        int len = s.length();
        if(len==0){
            return true;
        }
        else if (len%2!=0){
            return false;
        }
        else{
            Stack<String> st = new Stack<String>();
            for(int i=0;i<len;i++){
                String ch = Character.toString(s.charAt(i));
                switch(ch){
                    case "{":
                        st.push(ch);
                        break;

                    case "[":
                        st.push(ch);
                        break;

                    case "(":
                        st.push(ch);
                        break;

                    case "}":
                        if(st.empty()){
                            return false;
                        }
                        String p = st.pop();
                        if(!p.equalsIgnoreCase("{")){
                            return false;
                        }
                        break;

                    case "]":
                        if(st.empty()){
                            return false;
                        }
                        String q = st.pop();
                        if(!q.equalsIgnoreCase("[")){
                            return false;
                        }
                        break;
                    case ")":
                        if(st.empty()){
                            return false;
                        }
                        String r = st.pop();
                        if(!r.equalsIgnoreCase("(")){
                            return false;
                        }
                        break;
                }
            }
            if(st.empty()){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("The string '()[]{}' is valid:"+isValid("()[]{}"));
        System.out.println("The string '()[]{}' is valid:"+isValid("()[{}"));
    }
}