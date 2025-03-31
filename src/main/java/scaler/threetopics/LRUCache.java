package scaler.threetopics;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(3,2);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        lruCache.put(4,3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
    Map<Integer, DLL> map;
    DLL head;
    DLL tail;
    int mapCapacity;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        mapCapacity=capacity;
        head=new DLL(-1, -1);
        tail=new DLL(-1, -1);
        head.next=tail;
        tail.prev=head;

    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value=map.get(key).val;
            DLL node=map.get(key);
            delete_a_node(this.head,node);
            map.remove(key);
            insert_at_tail(node);
            map.put(key,node);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(this.map.containsKey(key)){
            // It is part of the cache.
            DLL temp=map.get(key);
            //Delete temp from double linked list
            delete_a_node(this.head, temp);
            map.remove(key);
            //Insert new node at the tail of double linked list
            DLL newNode=new DLL(key, value);
            insert_at_tail(newNode);
            map.put(key,newNode);

        }
        else{
            if(map.size()==this.mapCapacity){
                // It is full, need to evac
                map.remove(this.head.next.key);
                delete_at_head(this.head);
                DLL newNode=new DLL(key,value);
                insert_at_tail(newNode);
                map.put(key,newNode);
            }
            else{
                DLL newNode=new DLL(key,value);
                insert_at_tail(newNode);
                map.put(key,newNode);
            }
        }
    }
    private void delete_at_head(DLL head){
        DLL temp=head.next;
        head.next=temp.next;
        temp.next.prev=head;
        temp.next=null;
        temp.prev=null;
    }
    //It is basically inserting at the second last position to tail
    private void insert_at_tail(DLL newNode){
        DLL temp=this.tail.prev;
        temp.next=newNode;
        newNode.next=tail;
        this.tail.prev=newNode;
        newNode.prev=temp;
    }
    private void delete_a_node(DLL head, DLL node){
        DLL prev=node.prev;
        prev.next=node.next;
        node.next.prev=prev;
        node.next=null;
        node.prev=null;
    }

}
class DLL{
    int key;
    int val;
    DLL next;
    DLL prev;

    DLL(int key ,int val){
        this.key=key;
        this.val=val;
        this.next=null;
        this.prev=null;
    }
}
