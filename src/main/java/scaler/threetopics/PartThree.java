package scaler.threetopics;

public class PartThree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(5);
        root.right=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.right.right.left=new TreeNode(8);
        root.right.right.right=new TreeNode(9);
        inOrderTraversal(root);
        int[] preOrder={8,6,2,11,16,10,12,4,14,18,9,15};
        int[] inOrder={11,2,16,6,10,12,8,14,18,4,9,15};
//        int[] preOrder={8,6,14};
//        int[] inOrder={6,8,14};
        int N=preOrder.length;
        TreeNode rooty=constructTree(preOrder,0,N-1,inOrder,0,N-1);
        System.out.println(rooty);
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
