package scaler.threetopics;

public class PartFive {
    static int maxAns=0;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
//        root.left=new TreeNode(3);
//        root.left.left=new TreeNode(4);
//        root.left.left.left=new TreeNode(2);
//        root.left.right=new TreeNode(6);
//        root.left.right.left=new TreeNode(3);
//        root.left.right.right=new TreeNode(4);
//        root.left.right.right.right=new TreeNode(1);
//        root.right=new TreeNode(7);
//        root.right.left=new TreeNode(5);
//        root.right.right=new TreeNode(6);
        diameter(root);
        System.out.println(maxAns);
    }
    private static int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int lst=diameter(root.left);
        int rst=diameter(root.right);
        maxAns=Math.max(maxAns,lst+rst);
        return Math.max(lst,rst)+1;
    }
    private static boolean check(TreeNode root, int K){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null ){
            return root.val==K;
        }
        boolean left=check(root.left, K-root.val);
        boolean right=check(root.right, K- root.val);
        return left||right;
    }

    private static int sum(TreeNode root){
        if(root==null) return 0;
        return root.val+sum(root.left)+sum(root.right);
    }
    private static int find(TreeNode root, int s){
        if(root==null) return 0;
        int lst=find(root.left,s);
        int rst=find(root.right,s);
        if(lst==s/2 || rst==s/2){
            System.out.println("Break one of the nodes at root: "+root.val);
        }
        return root.val+lst+rst;
    }
    private static TreeNode invert(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invert(root.left);
        invert(root.right);
        return root;
    }
}
