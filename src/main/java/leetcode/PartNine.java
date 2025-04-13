package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PartNine {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(236);
        root.left=new TreeNode(104);
        root.left.right=new TreeNode(227);
        root.right=new TreeNode(701);
        root.right.right=new TreeNode(911);
        List<Integer> path=new ArrayList<>();
        System.out.println(_getMinimumDifference(root,path));

    }
    public static int getMinimumDifference(TreeNode root) {
        int minDiff=Integer.MAX_VALUE;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode popped=queue.poll();
            if(popped.left !=null){
                minDiff=Math.min(minDiff,Math.abs(popped.val-popped.left.val));
                queue.add(popped.left);
            }
            if(popped.right !=null){
                minDiff=Math.min(minDiff,Math.abs(popped.val-popped.right.val));
                queue.add(popped.right);
            }
        }
        return minDiff;
    }
    public static List<Integer> _getMinimumDifference(TreeNode root, List<Integer> path) {
        if(root==null) return path;
        _getMinimumDifference(root.left,path);
        path.add(root.val);
        _getMinimumDifference(root.right,path);
        return path;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val== p.val || root.val==q.val){
            return root;
        }
        else if(root.val>p.val && root.val<q.val){
            return root;
        }
        else if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }
    public static boolean findTarget(TreeNode root, int k, TreeNode tempRoot) {
        if(root==null) return false;
         int curr=root.val;
         int target=k-root.val;
         if(curr==target){
             TreeNode targetNode=searchBST(root.left,k-root.val) ;
             if(targetNode !=null) return true;
         }
         else{
             TreeNode targetNode=searchBST(tempRoot,k-root.val) ;
             if(targetNode !=null) return true;
         }
        return findTarget(root.left,k,tempRoot)||findTarget(root.right,k,tempRoot);
    }
    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if(start>end) return null;
        if(start==end){
            return new TreeNode(nums[start]);
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayToBST(nums,start,mid-1);
        root.right=sortedArrayToBST(nums,mid+1,end);
        return root;
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
       if(root==null){
           TreeNode newNode=new TreeNode(val);
           return newNode;
       }
       if(val<root.val){
           root.left= insertIntoBST(root.left,val);
       }
       else{
           root.right= insertIntoBST(root.right,val);
       }
       return root;
    }
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val==val){
            return root;
        }
        else if(val< root.val){
            return searchBST(root.left,val);
        }
        else {
            return searchBST(root.right,val);
        }
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
