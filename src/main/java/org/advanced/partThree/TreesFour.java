package org.advanced.partThree;

import java.io.FilterOutputStream;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TreesFour {
    private static TreeNode setUp(){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.left.left=new TreeNode(2);
        root.left.right=new TreeNode(6);
        root.left.right.left=new TreeNode(3);
        root.left.right.right=new TreeNode(4);
        root.left.right.right.right=new TreeNode(1);
        root.right=new TreeNode(7);
        root.right.right=new TreeNode(6);
        root.right.left=new TreeNode(5);
        return root;
    }
    static boolean canSplit=false;
    static int lSum=0;
    static int rSum=0;
    public static void main(String[] args) {
        TreeNode root=setUp();
        //invertBT(root);
        System.out.println("Yo");
        //sumBT(root);
        System.out.println(canSplit);
        System.out.println(setUpNext(root));
    }
    private static TreeNode setUpNext(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        //First Just Print In Order Traversal
        queue.add(root);

        while (queue.size()!=0){
            int size=queue.size();
            for(int i=0; i<size;i++){
                TreeNode temp=queue.poll();
                if(i<size-1) temp.next=queue.peek();
                if (temp.left !=null) queue.add(temp.left);
                if (temp.right !=null) queue.add(temp.right);
            }
            System.out.println("*****");
        }

        return root;
    }
    private static int sumBT(TreeNode root){
        System.out.println("Called");
        if(root==null) return 0;
        lSum +=sumBT(root.left);
        rSum +=sumBT(root.right);
        if(Math.abs(lSum-rSum)==root.val){
            System.out.println("At root: "+root.val);
            canSplit=true;
        }
        return root.val;
    }
    private static void invertBT(TreeNode root){
        if (root==null) return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertBT(root.left);
        invertBT(root.right);
    }

}
