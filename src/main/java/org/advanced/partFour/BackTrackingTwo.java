package org.advanced.partFour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BackTrackingTwo {
    public static void main(String[] args) {
        String A="23";
        ArrayList<String> initial=new ArrayList<>();
        initial.add("");
        ArrayList<String> temp=new ArrayList<>();
        String remaining="abc";
        int n=1;
        String ans="";
        //merge(initial, temp, ans, n, remaining);
        //System.out.println(temp);
        initial=temp;
        temp=new ArrayList<>();
        remaining="def";
        n=2;
        //merge(initial,temp, ans, n ,remaining);
        //System.out.println(temp);
        mains("2465");
//        initial.add("a");
//        initial.add("b");
//        initial.add("c");
//        String remaining="def";
//        int N=1+1;
//        String ans="";
//        int remIdx=0;
//        ///digital(temp,initial,remaining,N,ans);
//        //System.out.println(temp);
//        mains("23");
    }
    private static void mains(String A){
        Map<Character,String> map=new HashMap<>();
        map.put('0',"0");
        map.put('1',"1");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        int N=A.length();
        ArrayList<String> initial=new ArrayList<>();
        initial.add("");
        ArrayList<String> temp=new ArrayList<>();
        String ans="";
        int counter=0;
        for(int i=0; i<A.length(); i++){
            counter++;
            String remaining=map.get(A.charAt(i));
            merge(initial,temp, ans,counter, remaining);
            initial=temp;
            temp=new ArrayList<>();
        }
        String[] result=new String[initial.size()];
        for(int i=0; i<initial.size();i++) result[i]=initial.get(i);
        System.out.println(result);
    }
    private static void merge(ArrayList<String> initial,ArrayList<String>temp,String ans,int n,  String remaining){
        if(ans.length()==n){
            //System.out.println(ans);
            temp.add(ans);
            return;
        }
        for(int i=0; i<initial.size();i++){
            ans +=initial.get(i);
            for(int j=0; j<remaining.length();j++){
                ans +=remaining.charAt(j);
                merge(initial,temp,ans,n,remaining);
                ans=ans.substring(0,ans.length()-1);
            }
            ans="";
        }
    }
    private static void digital(ArrayList<String>temp,ArrayList<String> initial, String remaining, int n, String ans) {
        if(ans.length()==n){
            //System.out.println(ans);
            temp.add(ans);
            return;
        }
        for(int i=0; i<initial.size();i++){
            ans +=initial.get(i);
            for(int j=0; j<remaining.length();j++){
                ans +=remaining.charAt(j);
                digital(temp,initial,remaining,n,ans);
                ans=ans.substring(0,ans.length()-1);
            }
            ans="";
        }
    }
}
