package com.main.programs;
import java.io.*;
import java.util.*;
import java.lang.*;

/*
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a
valid dictionary word. Return all such possible sentences in any order.

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
 */

public class WordBreak{

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> dp = new HashMap<>();
        for(int i = 0 ; i<= s.length(); i++){
            List<List<String>> one = new ArrayList<>();
            dp.put(i,one);
        }

        for(int i = 1 ; i <= s.length(); i++){
            for(int j = 0 ; j < i; j++){
                if(wordDict.contains(s.substring(j, i))){
                    if(j == 0){
                        List<String> sen = new ArrayList<>();
                        sen.add(s.substring(j, i));
                        dp.get(i).add(sen);
                    }else if(dp.get(j).size() != 0){
                        for(int m = 0 ; m < dp.get(j).size() ; m++){
                            List<String> sen = new ArrayList<>();
                            sen.addAll(dp.get(j).get(m));
                            sen.add(s.substring(j, i));
                            dp.get(i).add(sen);
                        }
                    }
                }
            }
        }

        List<List<String>> res = dp.get(s.length());
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < res.size(); i++){
            result.add(String.join(" ",res.get(i)));
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cats");
        String s = "catsanddog";
        List<String> res = wordBreak(s, wordDict);
            for(String r:res){
                System.out.println(r+" ");
            }
    }
}