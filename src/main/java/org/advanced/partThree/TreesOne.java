package org.advanced.partThree;

import org.amadeus.oops.polymorphism.C;

import java.util.*;

public class TreesOne {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(8);
        root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(9);
        root.left.right.right=new TreeNode(10);
        root.right.right=new TreeNode(6);
//        root.left.right.right=new TreeNode(25);
//        root.right=new TreeNode(3);
//        root.right.right=new TreeNode(19);
//        root.right.right.left=new TreeNode(3);
        //root.right.right.right=new TreeNode(45);
        //postOrder(root);
        //ArrayList<Integer> ans=new ArrayList<>();
        //postOrder(root,ans);
        //System.out.println(ans);
        levelOrder(root);
        //topView(root);
        //serializeTree(root);
        Integer[] tree={1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1};
        ArrayList<Integer> A=new ArrayList<>(Arrays.asList(tree));
        //deSerializeTree(A);
    }
    public static TreeNode deSerializeTree(ArrayList<Integer>A){
        Queue<TreeNode> queue=new LinkedList<>();
        int idx=1;
        TreeNode root=new TreeNode(A.get(0));
        queue.add(root);
        while (queue.size() !=0){
            TreeNode temp=queue.poll();
            if(temp ==null){
                continue;
            }
            else{
                int left=A.get(idx);
                int right=A.get(idx+1);

                if(left==-1) temp.left=null;
                else temp.left=new TreeNode(left);

                if(right==-1) temp.right=null;
                else temp.right=new TreeNode(right);

                queue.add(temp.left);
                queue.add(temp.right);
                idx +=2;
            }

        }
        return root;
    }
    public static void serializeTree(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp.val ==-1){
                ans.add(-1);
            }
            else{
               ans.add(temp.val);
                if(temp.left !=null) {
                    queue.add(temp.left);
                }else{
                    queue.add(new TreeNode(-1));
                }
                if(temp.right !=null){
                    queue.add(temp.right);
                }
                else {
                    queue.add(new TreeNode(-1));
                }
            }
        }
        System.out.println(ans);
    }
    public static ArrayList<Integer> topView(TreeNode A){
        // First print vertical traversal
        ArrayList<Integer> ans=new ArrayList<>();
        TreeNode root=A;
        Pair<TreeNode, Integer> root_pair = new Pair<>(root,0);
        Queue<Pair> queue=new LinkedList<>();
        queue.add(root_pair);
        Map<Integer, ArrayList<Integer>> map=new HashMap<>();
        while (!queue.isEmpty()){
            Pair tempPair=queue.poll();
            TreeNode temp=(TreeNode) tempPair.getKey();
            Integer index= (Integer) tempPair.getValue();
            if(temp.left !=null){
                queue.add(new Pair(temp.left, index-1));
            }
            if(temp.right !=null){
                queue.add(new Pair(temp.right, index+1));
            }
            ArrayList<Integer> tempList=map.get(index);
            if(tempList==null){
                tempList=new ArrayList<>();
            }
            tempList.add(temp.val);
            map.put(index,tempList);
            //if(tempPair)
        }
        int minLevel=Collections.min(map.keySet());
        int maxLevel=Collections.max(map.keySet());

        for(int i=minLevel; i<=maxLevel;i++){
            ArrayList<Integer> tList=map.get(i);
            for(int j=0; j<tList.size();j++){
                ans.add(tList.get(j));
            }
        }
        return ans;
    }
    public static void levelOrder(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int counter=1;
        while (!queue.isEmpty()){
            int sz=queue.size();
            boolean normal=counter%2==0;
            for(int i=0; i<sz;i++){
                TreeNode out=queue.poll();
                //if(i==sz-1)
                System.out.println(out.val);
                if(normal){
                    if(out.left !=null) queue.add(out.left);
                    if(out.right !=null) queue.add(out.right);
                }
                else {
                    if(out.right !=null) queue.add(out.right);
                    if(out.left !=null) queue.add(out.left);
                }

            }
            counter++;
            System.out.println();
        }
    }
    public static void postOrder(TreeNode root, ArrayList<Integer> ans){
        if(root==null) return;
        postOrder(root.left,ans);
        postOrder(root.right,ans);
        ans.add(root.val);
        //System.out.println(root.val);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode next;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
       next=null;
      }
  }
