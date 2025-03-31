package org.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class AugustOne {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs){
        String ans="";
        for(int i=0; i<strs[0].length();i++){
            char toCompare=strs[0].charAt(i);
            for(int j=0; j<strs.length;j++){
                String word=strs[j];
                if(i<word.length() && toCompare==word.charAt(i)){
                    continue;
                }
                else {
                    return ans;
                }
            }
            ans +=toCompare;
        }
        return ans;
    }
}
