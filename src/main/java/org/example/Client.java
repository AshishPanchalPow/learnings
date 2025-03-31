package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        int x=10;
        sum(x);
        String[] array= {};
        List<String> myList= new ArrayList<>(Arrays.asList(array));
        System.out.println(maxPrefixSubArray(myList,myList.get(0),1));
    }
    private static void sum(int y){
        y +=10;
        System.out.println(y);
    }
    private static String maxPrefixSubArray(List<String> myList, String currMatch, int currInlist){
        if(currInlist==myList.size() || currMatch.isEmpty()){
            return currMatch;
        }
        String some=findCommonBetweenTwo(myList.get(currInlist),currMatch);
        return maxPrefixSubArray(myList, some, currInlist+1);

    }

    private static String findCommonBetweenTwo(String s1, String s2){
        int i=0;
        while(i<s1.length() && i<s2.length()&& s1.charAt(i)==s2.charAt(i)){
            i++;
        }
        return s1.substring(0, i);
    }
}
