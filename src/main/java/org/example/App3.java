package org.example;

import java.util.*;

//Sorting stuff
public class App3 {
    public static void main(String[] args) {
        Integer[] myarray={10,2,3,11};
        Arrays.sort(myarray, new DescendingComparator());
        //System.out.println(Arrays.toString(myarray));
        int[] binaryArr={0,1,1,1,0,1,1,0,1,1,0};
        //max1s(binaryArr);
        String A="000000000000000";
        maxx1s(A);
        twoPower(5,4);
        Integer[] arr= {1,5,3,9,7};
        ArrayList<Integer> list= new ArrayList<Integer>(Arrays.asList(arr));
        solve(list,2);

    }

    private static String solve(final List<Integer> A, final int B){
        Collections.sort(A);
        for(int i=1; i<A.size(); i++){
            if(A.get(i)-A.get(i-1)==B){

            }
            else{
                return "No";
            }
        }
        return "Yes";
    }
    private static int max1s(int[] input){
        int ans=0;
        for(int i=0; i<input.length;i++){
            int left=0; int right=0;
            if(input[i]==0){
                int j=i; int k=i+1;
                while (j>0 && input[j-1]==1){
                    left++; j--;
                }
                while (k<input.length && input[k]==1){
                    right++; k++;
                }
                ans=Math.max(left+right+1,ans);
            }

        }
        System.out.println("Ans: "+ans);
        return ans;

    }

    private static int twoPower(int A, int B){
        // Calc 2raise to power B
        int twoPowerB=1;
        for(int i=1;i<=B; i++) {twoPowerB *=2;}
        int ans=0;
        for(int i=0; i<A; i++){
            ans +=twoPowerB;
            twoPowerB *=2;
        }
        return ans;
    }

    private static int maxx1s(String A){
       int ans=0;
       int N=A.length();
       int total1s=0;
       for(int i=0;i<N;i++) if(A.charAt(i)=='1') total1s++;
       if(total1s==N) return N;
       for(int i=0; i<N; i++){
           if(A.charAt(i)=='0'){
               // count l
               int l=0;
               for(int j=i-1; j>=0; j--){
                   if(A.charAt(j)=='1') l++;
                   else break;
               }
               int r=0;
               for(int k=i+1;k<N; k++){
                   if(A.charAt(k)=='1') r++;
                   else break;
               }
               if(l+r==total1s) ans=Math.max(ans,l+r);
               else ans=Math.max(ans,l+r+1);
           }
       }
        System.out.println("Ans: "+ans);
        return  ans;
    }
}

class CustomComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        int o1sDigit=get10sDigit(o1);
        int o2sDigit=get10sDigit(o2);
        if(o1sDigit>o2sDigit) return 1;
        else if(o1sDigit<o2sDigit) return -1;
        else return o1-o2;

    }
    private int get10sDigit(Integer num){
        if(num<10) return 0;
        return (num/10)%10;
    }
}
class DescendingComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
