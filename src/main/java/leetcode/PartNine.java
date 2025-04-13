package leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PartNine {
    int globalAns=0;
    int count=0;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        root.left=new TreeNode(-5);
        root.left.right=new TreeNode(-3);
        root.left.right.left=new TreeNode(-4);
        root.left.right.right=new TreeNode(-1);
        root.left.left=new TreeNode(-10);
        System.out.println(maxVal(root.left));

    }
    public void kthSmallest(TreeNode root, int k) {
        if(root==null){
            return;
        }
        kthSmallest(root.left,k);
        count++;
        if(count==k){
            globalAns=root.val;
        }
        kthSmallest(root.right,k);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        else {
            if(root.left==null && root.right==null){
                return null;
            }
            else if(root.left==null && root.right !=null){
                return root.right;
            }
            else if(root.right==null && root.left !=null){
                return root.left;
            }
            else{
                //
                int val=maxVal(root.left);
                root.val=val;
                return deleteNode(root.left,val);
            }
        }
        return root;
    }
    private static int maxVal(TreeNode root){
        int maxVal=root.val;
        while(root !=null){
            if(root.right==null){
                root=root.left;
            }
            else {
                root=root.right;
                maxVal=Math.max(maxVal,root.val);
            }
        }
        return maxVal;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> path=getPath(root);
        return sortedArrayToBST(path,0,path.size()-1);
    }
    public List<Integer> getPath(TreeNode root){
        List<Integer> path=new ArrayList<>();
        _getMinimumDifference(root,path);
        return path;
    }
    public static TreeNode sortedArrayToBST(List<Integer> path, int start, int end) {
        if(start>end) return null;
        if(start==end){
            return new TreeNode(path.get(start));
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(path.get(mid));
        root.left=sortedArrayToBST(path,start,mid-1);
        root.right=sortedArrayToBST(path,mid+1,end);
        return root;
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
