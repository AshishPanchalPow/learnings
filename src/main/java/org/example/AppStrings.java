package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class AppStrings {
    public static void main(String[] args) {
        String s1="Hi";
        String s2=s1;
        s2 +="Ui";
        String str="ScALer";
        upperCase(str);
        System.out.println((int)'a');
        System.out.println((int)'A');
        Integer[] array={6,3,3,6,7,8,7,3,7};
        ArrayList<Integer> arrList=new ArrayList<>(Arrays.asList(array));
        countSort(arrList);
        String A = "   the  sky is blue     ";
        for(int i=0; i<A.length();i++){
            if(A.charAt(i) !=' '){
                String local="";
                while(A.charAt(i) !=' '){
                    local +=(A.charAt(i));
                    i++;
                }
                System.out.println(local);
            }

        }
        System.out.println(A.length());
    }

    private static ArrayList<Integer> countSort(ArrayList<Integer> A){
        // Find minimum element
        Integer minEl=A.get(0);
        Integer maxEl=A.get(0);
        for(int i=1; i<A.size();i++) {
            if (A.get(i) < minEl) minEl = A.get(i);
            if (A.get(i) > maxEl) maxEl = A.get(i);
        }
        ArrayList<Integer> freqList=new ArrayList<>(maxEl-minEl+1);
        for(int i=0; i<=maxEl-minEl; i++){
            freqList.add(i,0);
        }
        // Filling the freqList
        for(int i=0; i<A.size();i++){
            Integer targetIndex=A.get(i)-minEl;
            Integer localVal=freqList.get(targetIndex);
            localVal++;
            freqList.set(targetIndex,localVal);
        }
        System.out.println(freqList);
        // Start Iterating over freqList
        ArrayList<Integer> answer=new ArrayList<>();
        for(int i=0; i<freqList.size(); i++){
            Integer freq=freqList.get(i);
            if(freq!=0){
                while(freq !=0){
                    answer.add(i+minEl);
                    freq--;
                }
            }
        }
        return answer;

    }

    private static String upperCase(String str){
        String ans="";
        for(int i=0; i<str.length(); i++){
            int startOfLower=(int)'a';
            int charActual=(int)str.charAt(i);
            if(charActual>=startOfLower) charActual -=32;
            ans +=(char)charActual;

        }
        System.out.println("Ans: "+ans);
        return "";
    }

}
