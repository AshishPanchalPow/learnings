package org.leetcode;

public class JanuaryThree {
    public static void main(String[] args) {
        System.out.println("Hi");
        String s1="dfacl";
        String s2="fgl";
        //System.out.println(lcs(s1,s2,s1.length()-1,s2.length()-1));
        //System.out.println(minMoves(s1,s2,s1.length()-1,s2.length()-1));
        int[] numbers={10,3,12,7,9,11,20,11,13,6,8};
        int[] dp={0,0,0,0,0,0,0,0,0,0,0};
        //System.out.println(lisTD(numbers,dp));
        //int[] numbers={0,3,6,9,4,7,10,12,15,18};
        //System.out.println(lis(numbers,0,Integer.MIN_VALUE));
        int[] heights={5,6,6,4};
        int[] widths={6,4,7,3};
        final int aConstant;
        int some=20;
        aConstant=some;
        System.out.println(aConstant);
        some=30;
        System.out.println(aConstant);


    }
    private static int russian(int[] heights, int[] widths, int index){

        for(int i=0; i<heights.length;i++){
            int currHeight=heights[i];
            int currWidth=widths[i];
            for(int j=0; j<heights.length;j++){
                if(currHeight<heights[j] && currWidth<widths[j]){
                    return 1+russian(heights,widths,j);
                }
            }
        }
        return 0;
    }

    private static int lisTD(int[] numbers, int[] dp){
        dp[0]=1;
        int max=0;
        for(int i=1; i<numbers.length;i++){
            int t_max=0;
            for(int j=0; j<i; j++){
                if(numbers[j]<numbers[i]){
                    t_max=Math.max(t_max,dp[j]);
                }
            }
            dp[i]=t_max+1;
            max=Math.max(dp[i],max);
        }
        return max;

    }
    private static int lis(int[] numbers, int index, int currMax){
        System.out.println("Called for: "+index+ " "+ currMax);
        if(index==numbers.length){
            return 0;
        }
        int maxLength=0;
        int currEl=numbers[index];
        //Pick current element
        int pickedLength=0;
        int notPickedLength=0;
        if(currEl>currMax){
            pickedLength= 1+lis(numbers,index+1,currEl);
        }
        notPickedLength=lis(numbers,index+1,currMax);
        maxLength=Math.max(pickedLength,notPickedLength);
        return maxLength;
    }
    private static int minMoves(String s1, String s2, int idx1, int idx2){
        if(idx1 <0 &&idx2<0){
            return 0;
        }
        else if(idx1<0){
            return idx2+1;
        }
        else if(idx2<0){
            return idx1+1;
        }
        int minMove;
        if(s1.charAt(idx1) ==s2.charAt(idx2)) {
            minMove=minMoves(s1,s2,idx1-1,idx2-1);
        }
        else{
            int insert=minMoves(s1,s2,idx1,idx2-1);
            int delete=minMoves(s1,s2,idx1-1,idx2);
            int update=minMoves(s1,s2,idx1-1,idx2-1);
            minMove=Math.min(insert,delete);
            minMove=Math.min(minMove,update);
            minMove +=1;
        }
        return minMove;
    }
    private static int lcs(String s1, String s2, int idx1, int idx2){
        if(idx1==-1|| idx2==-1){
            return 0;
        }
        int maxLength;
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            maxLength =1+lcs(s1,s2,idx1-1,idx2-1);
        }
        else {
            maxLength =Math.max(lcs(s1,s2,idx1,idx2-1),lcs(s1,s2,idx1-1,idx2));
        }
        return maxLength;
    }
}