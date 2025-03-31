package org.advanced.partFour;

import java.util.HashMap;
import java.util.Map;

public class TrieOne {
    public static void main(String[] args) {
        String apple="apple";
        TrieNode root=new TrieNode('-');
        String[] words={"apple","app","cat","dog","ap"};
        for(String word: words) insertString(root,word);
        System.out.println(searchString(root,"cat"));
    }
    private static boolean searchString(TrieNode root, String word){
        TrieNode curr=root;
        for(int i=0; i<word.length();i++){
            if(!curr.children.containsKey(word.charAt(i))){
                return false;
            }
            curr=curr.children.get(word.charAt(i));
        }

        return curr.eow;
    }
    private static TrieNode insertString(TrieNode root, String str){
        TrieNode curr=root;
        for(int i=0; i<str.length();i++){
            if(curr.children.containsKey(str.charAt(i))){
                curr=curr.children.get(str.charAt(i));
            }
            else {
                TrieNode newNode=new TrieNode(str.charAt(i));
                curr.children.put(str.charAt(i), newNode);
                curr=newNode;
            }
        }
        curr.eow=true;
        return root;
    }
}
class TrieNode{
    Character val;
    boolean eow;
    Map<Character, TrieNode> children;
    TrieNode(Character ch){
        val=ch;
        eow=false;
        children=new HashMap<Character, TrieNode>();
    }
}
