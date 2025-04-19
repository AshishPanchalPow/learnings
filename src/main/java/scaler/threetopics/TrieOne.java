package scaler.threetopics;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.Map;

public class TrieOne {
    public static void main(String[] args) {
        String[] dict={"play","player","try","trick","trim"};
        Node root=new Node('-');
        for(String s: dict) insert(s,root);
        delete(root,"try");
        System.out.println(search(root,"play"));
    }
    public static void delete(Node root, String str){
        Node curr=root;
        Node temp=root;
        char nc=' ';
        for(int i=0; i< str.length();i++){
            int count=curr.children.size();
            if(count>1 || curr.eow==true){
                temp=curr;
                nc=str.charAt(i);
            }
            curr=curr.children.get(str.charAt(i));
        }
        curr.eow=false;
        int count=curr.children.size();
        if(count>0)return;
        temp.children.remove(nc);
    }
    public static boolean search(Node root, String s){
        Node temp=root;
        for(int i=0;i<s.length();i++){
            if(temp.children.containsKey(s.charAt(i))){
                temp=temp.children.get(s.charAt(i));
            }
            else{
                return false;
            }
        }
        return temp.eow;

    }
    public static Node  insert(String s, Node root){
        Node curr=root;
        for(int i=0; i<s.length();i++){
            if(!curr.children.containsKey(s.charAt(i))){
                Node newNode=new Node(s.charAt(i));
                curr.children.put(s.charAt(i),newNode);
            }
            curr=curr.children.get(s.charAt(i));
        }
        curr.eow=true;
        return root;
    }
}
class Node{
    char data;
    boolean eow;
    Map<Character,Node> children;
    Node(char data){
        this.data=data;
        children=new HashMap<>();
        eow=false;
    }
}
