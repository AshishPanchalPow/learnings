package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RandomDays {
    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        String sentence="Hi there, i am Ashish.";
        String sentenceTwo=sentence+"Hol";
        StringBuilder stringBuilder=new StringBuilder(sentence);
        int index=stringBuilder.indexOf("Ashish");
        stringBuilder.insert(index,"cool ");
        stringBuilder.append(" 12");
        stringBuilder.delete(10,20);
        System.out.println(stringBuilder.toString());

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        String[] original=strs;
        for(int i=0; i<strs.length;i++){
            strs[i]=strs[i].chars().sorted().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
        }
        //System.out.println(Arrays.toString(strs));
        HashMap<String, List<String>> hashMap=new HashMap<>();
        for(int i=0; i<strs.length;i++){
            String str=strs[i];
            if(hashMap.containsKey(str)){
                List<String> list=hashMap.get(str);
                list.add(original[i]);
            }
            else {
                List<String> list=new ArrayList<>();
                list.add(original[i]);
                hashMap.put(str,list);
            }
        }
        List<List<String>> ans = new ArrayList<>(hashMap.values());

        return ans;
    }
}
