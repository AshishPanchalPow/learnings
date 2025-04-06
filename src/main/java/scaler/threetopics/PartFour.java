package scaler.threetopics;

public class PartFour {
    static int count=0; static int ans=0;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(20);
        root.left=new TreeNode(15);
        root.left.left=new TreeNode(12);
        root.left.right=new TreeNode(18);
        root.left.right.left=new TreeNode(17);
        root.right=new TreeNode(25);
        root.right.right=new TreeNode(30);
        root.right.right.left=new TreeNode(28);
        root.right.right.right=new TreeNode(40);
        //System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        kThSmallestInBST(root,7);
        System.out.println(ans);
    }
    private static void kThSmallestInBST(TreeNode root, int K){
        if(root==null){
            return ;
        }
        kThSmallestInBST(root.left,K);
        count++;
        if(count==K){
            ans=root.val;
            return;
        }
        kThSmallestInBST(root.right,K);
    }
    private static TreeNode construct(int[] array, int start, int end){
        int mid=(start+end)/2;
        if(start>end) return null;
        TreeNode root=new TreeNode(array[mid]);
        if(start==end) return root;
        root.left=construct(array,start, mid-1);
        root.right=construct(array,mid+1,end);
        return root;
    }
    private static boolean isBST(TreeNode root, int min, int max){
        if(root==null){
            return true;
        }
        if(root.val>min && root.val<max){
            boolean isLeft=isBST(root.left, min,root.val);
            boolean isRight=isBST(root.right, root.val, max);
            return isLeft && isRight;
        }
        return false;
    }
    private static TreeNode insert(TreeNode root, int K){
        if(root==null){
            TreeNode newNode=new TreeNode(K);
            return newNode;
        }
        if(root.val<K){
            root.right=insert(root.right, K);
        }
        else if(root.val>K){
            root.left=insert(root.left,K);
        }
        return root;
    }
    private static boolean search(TreeNode root, int K){
        if(root==null) return false;
        if(root.val==K){
            return true;
        }
        if(root.val<K){
            return search(root.right,K);
        }
        else{
            return search(root.left,K);
        }
    }
}
