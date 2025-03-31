package org.advanced.partTwo;
import  java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortingThree {
    public static void main(String[] args) {
        Integer[] nums={1,1,2,3,3,4,8,9,11,9,11,12,12,11,9,14,19,20,20};
        ArrayList<Integer> arrayList=new ArrayList<>(Arrays.asList(nums));
        //largestNumber(arrayList);
        subUnsort(arrayList);
    }
    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A){
        ArrayList<Integer> ans = new ArrayList<>(2);
        //Find starting index of dip
        int startIdx=-1;
        int endIdx=-1;
        for(int i=1; i<A.size()-1;i++){
            if(A.get(i)>A.get(i-1) && A.get(i)>A.get(i+1)){
                startIdx=i;
                break;
            }
        }
        if(startIdx==-1){
            ArrayList<Integer> one=new ArrayList<>(1);
            one.add(-1);
            return one;
        }
        Integer max=A.get(startIdx);
        for(int j=startIdx+1; j<A.size();j++){
            if(A.get(j)>max){
                endIdx=j;
                max=A.get(j);
            }
        }
        if(startIdx!=-1 && endIdx==-1){
            endIdx=A.size()-1;
        }
        ans.add(startIdx);
        ans.add(endIdx-1);
        System.out.println("Ans: "+ans);
        return ans;
    }
    public static String largestNumber(ArrayList<Integer> A){
        Collections.sort(A, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return (String.valueOf(b) + String.valueOf(a)).compareTo(String.valueOf(a) + String.valueOf(b));
            }
        });
        System.out.println(A);
        return "";
    }
}
class Order implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        String aPluB=String.valueOf(o1)+String.valueOf(o2);
        String bPluA=String.valueOf(o2)+String.valueOf(o1);
        return aPluB.compareTo(bPluA);
    }
}
