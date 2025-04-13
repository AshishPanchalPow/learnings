package scaler.threetopics;

import com.sun.source.tree.Tree;

import java.util.*;

public class PartSix {
    static int minDepth=Integer.MAX_VALUE;
    static int maxAns=0;
    public static void main(String[] args) {

        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.left.left=new TreeNode(2);
        root.left.right=new TreeNode(6);
        root.left.right.left=new TreeNode(3);
        root.left.right.right=new TreeNode(4);
        root.left.right.right.right=new TreeNode(1);
        root.right=new TreeNode(7);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);
        TreeNode rooty=new TreeNode(1);
        rooty.left=new TreeNode(2);
        List<Integer> path=new ArrayList<>();
        //path(rooty,2,path);
        System.out.println(path);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pathP=new ArrayList<>();
        ArrayList<TreeNode> pathQ=new ArrayList<>();
        path(root,p.val,pathP);
        path(root,q.val,pathQ);
        Collections.reverse(pathP);
        Collections.reverse(pathQ);
        int N=Math.max(pathP.size(),pathQ.size());
        TreeNode answer=root;
        for(int i=1; i<N;i++){
            if(pathP.get(i) !=pathQ.get(i)) break;
            answer=pathP.get(i);
        }
        return answer;
    }
    public static boolean path(TreeNode root, int K, List<TreeNode> path){
        if(root==null){
            return false;
        }
        if(root.val==K){
            path.add(root);
            return true;
        }
        boolean left= path(root.left,K,path);
        boolean right=path(root.right,K,path);
        if(left||right){
            path.add(root);
        }
        return left||right;
    }
    public static TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        root.left=invertTree(root.left);
        root.right=invertTree(root.right);
        return root;
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int left=diameterOfBinaryTree(root.left);
        int right=diameterOfBinaryTree(root.right);
        maxAns=Math.max(maxAns,left+right);
        return Math.max(left,right)+1;
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null && targetSum==root.val){
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val) ||hasPathSum(root.right,targetSum-root.val);
    }
    public static void inOrder(TreeNode root, List<Integer> result){
        if(root==null){
            return ;
        }
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val !=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> local=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode popped=queue.poll();
                local.add(popped.val);
                if(popped.left!=null) queue.add(popped.left);
                if(popped.right!=null) queue.add(popped.right);
            }
            answer.add(local);
        }
        return answer;
    }
        public static int minDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            if(root.left==null){
                return 1+minDepth(root.right);
            }
            if(root.right==null){
                return 1+minDepth(root.left);
            }

            return 1+Math.min(minDepth(root.right), minDepth(root.left));
        }
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            double total=0;
            for(int i=0;i<size;i++){
                TreeNode popped=queue.poll();
                total+=popped.val;
                if(popped.left!=null) queue.add(popped.left);
                if(popped.right!=null) queue.add(popped.right);
            }
            ans.add(total/size);
        }
        return ans;
    }
}
