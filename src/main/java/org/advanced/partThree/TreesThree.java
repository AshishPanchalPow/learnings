package org.advanced.partThree;

import com.sun.source.tree.Tree;

public class TreesThree {

    public static void main(String[] args) {

        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(0);
        root.left.left=new TreeNode(-1);
        root.left.right=new TreeNode(3);
        root.left.right.left=new TreeNode(2);
        root.right=new TreeNode(10);
        root.right.right=new TreeNode(15);
        root.right.left=new TreeNode(7);
        root.right.left.left=new TreeNode(6);
        root.right.left.right=new TreeNode(9);
        int count=0;
        int ans=0;
        findKth(root,4, count, ans);
        System.out.println(ans);
        System.out.println(isKPresent(root,9));
//        int[] array={2,10,6,9,7,8};
        int[] array={1,5,6,4};
        System.out.println(solve(array));
    }
    private static String solve(int[] A){
        int left=Integer.MIN_VALUE;
        int right=Integer.MAX_VALUE;
        int rootVal=A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]>rootVal){
                left=rootVal;
                if(A[i]>left && A[i]<right){
                    //continue;
                }
                else return "NO";
            }
            else if(A[i]<rootVal){
                right=rootVal;
                if(A[i]>left && A[i]<=right){
                    //continue;
                }
                else return "NO";
            }
            rootVal=A[i];
        }
        return "YES";
    }
    private static boolean isKPresent(TreeNode root, int K){

        if(root==null) return false;
        if(root.val==K) {
            System.out.println("Path: "+root.val);
            return true;
        }
        boolean isPresentOnLeft=isKPresent(root.left,K);
        if(isPresentOnLeft) System.out.println("Path: "+root.val);
        boolean isPresentOnRight=isKPresent(root.right,K);
        if(isPresentOnRight) System.out.println("Path: "+root.val);
        if(isPresentOnLeft | isPresentOnRight){
            return true;
        }
        return false;
    }
    private static void findKth(TreeNode root, int K,int count, int ans){
        if (root==null) return;
        findKth(root.left,K,count,ans);
        count++;
        if(count==K){
            ans=root.val;
        }
        findKth(root.right, K, count,ans);

    }
}
