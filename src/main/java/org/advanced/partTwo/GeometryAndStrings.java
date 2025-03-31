package org.advanced.partTwo;

import java.util.*;

public class GeometryAndStrings {
    public static void main(String[] args) {
        String A="abc";
        String B="abcbacabc";
        System.out.println(solve(A,B));
    }

    private static int isomorphic(String A, String B){
        HashMap<Character, Character> hm=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        if(A.length() !=B.length()) return 0;
        int N=A.length();
        for(int i=0; i<N; i++){
            char curr=A.charAt(i);
            //If curr is already mapped to a character
            if(hm.containsKey(curr)){
               if(hm.get(curr) !=B.charAt(i)) return 0;
            }
            else{
                hm.put(curr,B.charAt(i));
                if(set.contains(B.charAt(i))) return 0;
                set.add(B.charAt(i));
            }
        }
        return 1;
    }

    public static HashMap<Character,Integer> createFreqMap(String s, int length){
        HashMap<Character,Integer> fMap=new HashMap<>();
        int N=length;
        for(int i=0; i<N;i++){
            if(fMap.containsKey(s.charAt(i))){
                int x= fMap.get(s.charAt(i));
                x++;
                fMap.put(s.charAt(i),x);
            }
            else{
                fMap.put(s.charAt(i),1);
            }
        }
        return fMap;
    }
    public static int solve(String A, String B){
        int ans=0;
        int N=A.length();
        HashMap<Character,Integer> fA=createFreqMap(A,N);
        HashMap<Character,Integer> fB=createFreqMap(B,N);
        if(compare(fA,fB)) ans++;
        int i=0; int j=N;
        while (j<B.length()){
            // Reduce outgoing char from freq map
            int out=fB.get(B.charAt(i));
            out--;
            if(out==0) fB.remove(B.charAt(i));
            else fB.put(B.charAt(i),out);

            char in=B.charAt(j);
            if(fB.containsKey(in)){
                int y=fB.get(in);
                y++;
                fB.put(in,y);
            }
            else{
                fB.put(in,1);
            }
            i++;
            j++;
            if(compare(fA,fB)) ans++;
        }

        //System.out.println("Ans: "+ans);
        return ans;
    }
    public static boolean compare(HashMap<Character,Integer> fA,HashMap<Character,Integer> fB){

        for(Character ch: fA.keySet()){
            if(fB.containsKey(ch)){
                if(fB.get(ch) == fA.get(ch)){
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
