package org.advanced.partTwo;

import java.util.*;

public class HasingOne {
    public static void main(String[] args) {
        //int A=99;
        //System.out.println(colorful(A));
        String A="abcabcbb";
        lengthOfLongestSubstring(A);
        TreeMap<String,Integer> stringIntegerTreeMap=new TreeMap<>();
        stringIntegerTreeMap.put("Sunshine",32);
        stringIntegerTreeMap.put("Sunny",12);
        stringIntegerTreeMap.put("Ash",20);
        stringIntegerTreeMap.put("Bony",11);
        System.out.println(stringIntegerTreeMap);
        System.out.println(stringIntegerTreeMap.floorEntry("Cat"));
        System.out.println(stringIntegerTreeMap.higherKey("Dog"));
        int[] XCord={1,3,5,5,1};
        int[] YCord={3,3,3,1,1};
        int N=XCord.length;
        for(int i=0; i<N;i++){
            for(int j=0; j<N; j++){
                // Try to find a point with common X
                if(i !=j){
                    if(XCord[i]==XCord[j]){
                        for(int k=0; k<N; k++){
                            if(k !=i && k!=j){
                                if(YCord[i]==YCord[k]){
                                    //System.out.println("Centre: "+XCord[i] +" "+ YCord[i]);
                                }
                            }
                        }
                    }
                    if(YCord[i]==YCord[j]){
                        for(int k=0; k<N; k++){
                            if(k !=i && k!=j){
                                if(XCord[i]==XCord[k]){
                                    //System.out.println("Centre: "+XCord[i] +" "+ YCord[i]);
                                }
                            }
                        }
                    }
                }


                //Try to find a point with common Y
            }
        }

    }
    public static int lengthOfLongestSubstring(String A){
        int ans=0;
        Set<Character> hashSet=new HashSet<>();
        int N=A.length();
        int l=0; int r=1;
        hashSet.add(A.charAt(l));
        while (r<N){
            char inComingChar=A.charAt(r);
            if(hashSet.contains(inComingChar)){
                while (hashSet.contains(inComingChar)){
                    hashSet.remove(A.charAt(l));
                    l++;
                }
            }
            else {
                hashSet.add(inComingChar);
                ans=Math.max(ans,r-l+1);
                r++;
            }

        }
        //System.out.println("Ans:"+ans);
        return ans;
    }
    public static int colorful(int A){
        ArrayList<Integer> nums=new ArrayList<>();

        while(A>0){
            int numToInsert=A%10;
            nums.add(numToInsert);
            A=A/10;
        }
        int start=0; int end=nums.size()-1;
        while (start<=end){
            int temp=nums.get(start);
            nums.set(start,nums.get(end));
            nums.set(end,temp);
            start++;
            end--;
        }
        //System.out.println(nums);
        HashSet<Integer> products=new HashSet<>();
        int N=nums.size();

        for(int i=0; i<N; i++){
            int locProd=nums.get(i);
            if(products.contains(locProd)) return 0;
            products.add(locProd);
            for(int j=i+1; j<N; j++){
                locProd *=nums.get(j);
                if(products.contains(locProd)) return 0;
                products.add(locProd);
            }
        }
        return 1;
    }
}
