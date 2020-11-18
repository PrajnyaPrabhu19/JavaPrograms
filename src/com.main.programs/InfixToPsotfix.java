package com.main.programs;

/*
Convert an infix expression to postfix using stacks
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class InfixToPsotfix{

    public static int prec(char c){
        if(c == '+' || c=='-'){
            return 1;
        }
        else if( c=='*'||c=='/'){
            return 2;
        }

        else{
            return -1;
        }
    }

    public static String postfix(String exp){
        String result ="";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i< exp.length();i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result+=String.valueOf(c);
            }
            else if(c == '('){
                stack.push(c);
            }
            else if(c ==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    result+= stack.pop();
                }
                stack.pop();
            }
            else{
                //c is an operator, check for precedence
                while(!stack.isEmpty() && prec(c)<=prec(stack.peek())){
                    result+= stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            if(stack.peek() =='('){
                return "Invalid expression";
            }
            result+= stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String exp = "a+b*c-(d/e*f)";
        System.out.println("Infix expression: "+exp+" \nPostfix expression: "+postfix(exp));
    }

}