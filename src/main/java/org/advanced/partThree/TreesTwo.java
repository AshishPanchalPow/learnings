package org.advanced.partThree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreesTwo {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(20);
        root.left=new TreeNode(15);
        root.left.left=new TreeNode(12);
        root.left.right=new TreeNode(18);
        root.left.right.left=new TreeNode(17);
        root.right=new TreeNode(25);
        root.right.right=new TreeNode(30);
        root.right.right.left=new TreeNode(28);
        //System.out.println(search_BST(root,38));
        //root=insert_BST(root,27);
        //System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        int[] sorted_array={4, 10, 5, 8};
        TreeNode ans=makeBST(sorted_array,0,sorted_array.length-1);
        //printTree(ans);
        int[] arr={4, 10, 5, 8};
        printTree(makeTree(arr,0));
        //System.out.println(isBST(ans,Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    private static TreeNode makeTree(int[] arr, int index){
        if(index>=arr.length){
            return null;
        }
        TreeNode root=new TreeNode(arr[index]);
        if(root.val>arr[index]){
             root.left=makeTree(arr,index+1);

        }
        else {
            root.right=makeTree(arr,index+1);
        }
        return root;
    }
    private static TreeNode makeBST(int[] sorted_array, int start, int end){
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(sorted_array[mid]);
        //System.out.println("created a node with:"+ sorted_array[mid]);
        if(start==end) return root;
        root.left=makeBST(sorted_array, start, mid-1);
        root.right=makeBST(sorted_array, mid+1, end);
        return root;
    }
    private static boolean isBST(TreeNode root, int start, int end){
        //System.out.println("Range for root: "+start+" "+end);
        if(root==null) return true;
        if(root.val>=start && root.val <=end){
            boolean lst=isBST(root.left, start,root.val-1);
            boolean rst=isBST(root.right, root.val+1, end);
            return lst && rst;
        }
        return false;
    }
    private static boolean search_BST(TreeNode root, int K){
        //System.out.println("Called for : "+ root.val);
        if(root==null) return false;
        if(root.val==K) return true;
        if(root.val>=K) return search_BST(root.left, K);
        else return search_BST(root.right,K);
    }
    private static TreeNode insert_BST(TreeNode root, int K){
        if (root==null){
            TreeNode newNode=new TreeNode(K);
            return newNode;
        }
        if(root.val>=K){
            root.left=insert_BST(root.left,K);
        }
        else{
            root.right=insert_BST(root.right,K);
        }
        return root;
    }
    public static void printTree(TreeNode root) {
        List<List<String>> lines = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();

        level.add(root);
        int nn = 1;
        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();

            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = String.valueOf(n.val);
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perPiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perPiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    if (line.get(j) == null) {
                        for (int k = 0; k < perPiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            for (int j = 0; j < line.size(); j++) {
                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perPiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perPiece / 2f - f.length() / 2f);

                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perPiece /= 2;
        }
    }
}
