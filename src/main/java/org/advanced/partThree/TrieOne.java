package org.advanced.partThree;

import java.util.*;

public class TrieOne {
    public static void main(String[] args) {
        Trie root=new Trie('-');
        //insert(root,"car");
        String[] A = {"hat", "cat", "rat" };
        String[] B = {"cat", "ball"};
        String[] words={"zebra", "dog", "duck", "dove"};
        //for(String word:words) insert(root,word);
        ///System.out.println(searchCount(root,"duck"));
        //solve(A,B);
        int[] arr={5,10,15,20,25,30};
        //maxXOR(arr, root);
    }

    /* private static int maxXOR(int[] arr, Trie root) {
        int maxXOR=0;
        Trie temp=root;
        int height=5;
        for (int i=0; i<arr.length;i++){
            // For a given number try to form the max target.
            // Starting from MSB
            int localXOR=0;
            for(int j=height-1; j>=0;j--){
                // If bit is set
                if((arr[i] & (1<<j)) !=0){
                    if(temp.children[0] !=null){
                        localXOR += 2**j;
                        temp=temp.children[0];
                    }
                    else{
                        temp=temp.children[1];;
                    }
                }
                // If bit is unset, search for 1
                else{
                    if(temp.children[1].data==1){
                        localXOR += 2**j;
                    }
                    else{
                        continue;
                    }
                }
            }
            maxXOR=Math.max(localXOR,maxXOR);
        }
        return maxXOR;
    } */

    private static String[] prefix(String[] A){
        String[] ans=new String[A.length];
        Trie root=new Trie('-');
        for(String word: A) insert(root,word);

        return ans;
    }
    private static String searchCount(Trie root, String word){
        Trie temp=root;
        String ans="";
        for(int i=0; i<word.length();i++){
            int count= temp.children.get(word.charAt(i)).count;
            if(count>1) ans +=word.charAt(i);
            if(count==1) {
                ans +=word.charAt(i);
                break;
            }
            temp=temp.children.get(word.charAt(i));
        }
        return ans;
    }
    private static int[] solve(String[] A, String[] B){
        Trie root=new Trie('-');
        for(String dict: A) root=insert(root,dict);
        int[] ans=new int[B.length];
        Arrays.fill(ans,0);
        for(int i=0; i<B.length;i++){
            ans[i]=search(root,B[i]);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
    private static int search(Trie root, String word){
        Trie temp=root;
        for(int i=0; i<word.length();i++){
            if(!temp.children.containsKey(word.charAt(i))){
                return 0;
            }
            temp=temp.children.get(word.charAt(i));
        }
        return temp.eow?1:0;
    }
    private static Trie insert(Trie root, String word){
        Trie temp=root;
        for (int i=0; i<word.length();i++){
            if(!temp.children.containsKey(word.charAt(i))){
                temp.children.put(word.charAt(i), new Trie(word.charAt(i)));
            }
            else{
                Trie ref=temp.children.get(word.charAt(i));
                ref.count +=1;
            }
            temp=temp.children.get(word.charAt(i));
        }
        temp.eow=true;
        return root;
    }
}
class Trie{
    Character ch;
    int count;
    Map<Character, Trie> children;
    boolean eow;
    Trie(Character ch){
        ch=ch;
        children=new HashMap<>();
        eow=false;
        count=1;
    }
}
