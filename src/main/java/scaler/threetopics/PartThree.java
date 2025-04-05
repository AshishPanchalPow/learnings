package scaler.threetopics;

import java.util.*;

public class PartThree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.left.left=new TreeNode(6);
        root.right=new TreeNode(3);
        root.right.right=new TreeNode(7);
        root.right.right.right=new TreeNode(8);
        //inOrderTraversal(root);
        int[] preOrder={8,6,2,11,16,10  ,12,4,14,18,9,15};
        int[] inOrder={11,2,16,6,10,12,8,14,18,4,9,15};
        int N=preOrder.length;
        TreeNode rooty=constructTree(preOrder,0,N-1,inOrder,0,N-1);
        //verticalLevelOrderTraversal(rooty);
        //isBalancedBinaryTree(root);
        Integer[] A={1, 2, 3, -1, -1, -1, -1};
        Queue<Integer> queue=new LinkedList<>(Arrays.asList(A));
        TreeNode x=deserialize(A);
        System.out.println(x);
    }
    private static TreeNode deserialize(Integer[]A){
        Queue<TreeNode> queue=new LinkedList<>();
        int idx=1;
        TreeNode root=new TreeNode(A[0]);
        queue.add(root);
        while (idx <A.length){
            TreeNode temp=queue.poll();
            if(temp ==null){
                continue;
            }
            else{
                if(A[idx]==-1) temp.left=null;
                else {
                    temp.left=new TreeNode(A[idx]);
                    queue.add(temp.left);
                }
                idx++;
                if(A[idx]==-1) temp.right=null;
                else {
                    temp.right=new TreeNode(A[idx]);
                    queue.add(temp.right);
                }
                idx++;


            }

        }
        return root;
    }
    private static int isBalancedBinaryTree(TreeNode root){
        if(root==null)return 0;
        int lHeight=isBalancedBinaryTree(root.left);
        int rHeight=isBalancedBinaryTree(root.right);
        System.out.println("For root node: "+root.val+" Left Height: "+lHeight+" Right Height: "+rHeight);
        return Math.max(lHeight,rHeight)+1;
    }
    private static int[] solve(TreeNode A){
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()){
            TreeNode pop=queue.poll();
            if(pop.val!=-1){
                ans.add(pop.val);
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                else{
                    queue.add(new TreeNode(-1));
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
                else{
                    queue.add(new TreeNode(-1));
                }
            }
            else{
                ans.add(pop.val);
                //queue.poll();
            }
        }
        int[] result=new int[ans.size()];
        for(int i=0; i<ans.size();i++) result[i]=ans.get(i);
        return result;
    }
    private static void verticalLevelOrderTraversal(TreeNode root){
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(0, root));
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            if(pair.treeNode.left !=null){
                queue.add(new Pair(pair.index-1, pair.treeNode.left));
            }
            if(pair.treeNode.right !=null){
                queue.add(new Pair(pair.index+1, pair.treeNode.right));
            }
            if(map.containsKey(pair.index)){
                List<Integer> existing = map.get(pair.index);
                existing.add(pair.treeNode.val);
                map.put(pair.index, existing);
            }
            else {
                List<Integer> existing=new ArrayList<>();
                existing.add(pair.treeNode.val);
                map.put(pair.index, existing);
            }
        }
        System.out.println(map);
    }
    private static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode popped=queue.poll();
                if(i==0)  System.out.print(popped.val+" ");
                if(popped.left !=null) queue.add(popped.left);
                if(popped.right !=null) queue.add(popped.right);
            }
            System.out.println();
        }
        System.out.println("Done");
    }
    private static TreeNode constructTree(int[] preOrder, int ps, int pe, int[] inOrder, int is, int ie){
        if(ps>pe){
            return null;
        }
        int root_data=preOrder[ps];
        TreeNode root=new TreeNode(root_data);
        int index=indexOf(inOrder, root_data);
        int LST=index-is;
        root.left=constructTree(preOrder, ps+1,ps+LST, inOrder, is,index-1);
        root.right=constructTree(preOrder,ps+LST+1,pe, inOrder,index+1,ie);
        return root;
    }
    private static int indexOf(int[] inOrder, int val){
        int index=-1;
        for(int i=0; i<inOrder.length;i++) {
            if (inOrder[i] == val) return i;
        }
        return index;
    }
    public static void inOrderTraversal(TreeNode root){
        if(root==null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val);
        System.out.print(" ");
        inOrderTraversal(root.right);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        left=null;
        right=null;
    }
}
class Pair{
    int index;
    TreeNode treeNode;
    Pair(int index, TreeNode treeNode){
        this.index=index;
        this.treeNode=treeNode;
    }
}
