package scaler.threetopics;

import java.util.Arrays;

public class TriesTwo {
    static TreeNode prev;
    static TreeNode first;
    static TreeNode second;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(14);
        root.left.right.left=new TreeNode(7);
        root.right=new TreeNode(15);
        root.right.left=new TreeNode(13);
        root.right.left.right=new TreeNode(9);
        root.right.right=new TreeNode(20);
        root.right.right.left=new TreeNode(19);
        recoverTree(root);
        System.out.println(first.val);
        System.out.println(second.val);
    }
    public static void recoverTree(TreeNode root) {
        if(root==null){
            return;
        }
        recoverTree(root.left);
        if(prev !=null && prev.val >root.val && first ==null){
            first=prev;
            second=root;
        }
        else if(prev !=null && prev.val >root.val){
            second=root;
        }
        prev=root;
        recoverTree(root.right);
    }
    private static int maxXor(Node root, int[] nums, int height){
        int answer=0;
        for(int i=0;i<nums.length;i++){
            int localXOR=0; Node curr=root;
            for(int j=height-1;j>=0;i--){
                // Check if bit at j is set
                if((nums[i]&(1<<j)) !=0){
                    if(curr.children.get(0) !=null){
                        localXOR=localXOR |(1<<j);
                        curr=curr.children.get(0);
                    }
                    else{
                        curr=curr.children.get(1);
                    }
                }
                else {
                    if(curr.children.get(1) !=null){
                        localXOR=localXOR |(1<<j);
                        curr=curr.children.get(1);
                    }
                    else{
                        curr=curr.children.get(0);
                    }
                }
            }
            answer=Math.max(answer,localXOR);
        }
        return answer;
    }
    private static void flatten(TreeNode root){
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode K=root.right;
        if(root.left !=null){
            root.right=root.left;
            root.left=null;
            while(root.right !=null){
                root=root.right;
            }
            root.right=K;
        }
    }
}
