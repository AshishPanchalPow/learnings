package org.advanced.partThree;

import java.util.LinkedList;

public class LinkedListOne {
    public static void main(String[] args) {
        ListNode n1=new ListNode(10);ListNode n2=new ListNode(20);ListNode n3=new ListNode(30);ListNode n4=new ListNode(40);
        ListNode n5=new ListNode(50);ListNode n6=new ListNode(60);ListNode n7=new ListNode(70);ListNode n8=new ListNode(80);
        ListNode n9=new ListNode(90);
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;n6.next=n7;n7.next=n8;n8.next=n9;
        //System.out.println(n1);
        //ListNode newHead=reverseLL(n1);
        //lPalin(n1);
        //removeNthFromEnd(n1,20);
        //deleteDuplicates(n1);
        ListNode h=reverseList(n1,3);
        System.out.println("Yo");
    }
    public static ListNode reverseList(ListNode A, int B) {
        int ctr=0;
        ListNode prev=null;
        ListNode curr=A;
        ListNode fwd=null ;
        while(ctr !=B){
            fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
            ctr++;
        }
        if(fwd !=null) A.next=reverseList(fwd,B);
        return prev;
    }
    public static ListNode deleteDuplicates(ListNode A){
        ListNode curr=A;
        while (curr !=null){
            ListNode temp=curr; int data=curr.data;
            while (temp!=null &&temp.data ==data){
                temp=temp.next;
            }
            curr.next=temp;
            curr=temp;
        }

        return A;
    }
    public static ListNode removeNthFromEnd(ListNode A, int B){
        ListNode temp=A;
        int n=0;
        while (temp !=null){
            n++; temp=temp.next;
        }
        temp=A;
        if(B>n) B=n;
        int nodeIndexToRemove=n-B;
        if(nodeIndexToRemove==0){
            ListNode newHead=temp.next;
            temp.next=null;
            return newHead;
        }
        for(int i=0; i<nodeIndexToRemove-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return A;
    }
    public static int lPalin(ListNode A){
        ListNode head=A;
        ListNode temp=head;
        int n=0;
        while (temp != null) {
            n++; temp=temp.next;
        }
        //System.out.println("Length of Linked List is: "+n);
        temp=head; int i=0;
        int mid=n/2;
        while (i<mid){
            temp=temp.next;
            i++;
        }
        ListNode prev=null;ListNode curr=temp;
        while(curr !=null){
            ListNode fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
        }
        ListNode tHead=head;
        for(int j=0; j<mid; j++){
            if(tHead.data != prev.data){
                return 0;
            }
            tHead=tHead.next;
            prev=prev.next;
        }
        return 1;
    }
    public static ListNode reverseLL(ListNode A){
        ListNode temp=A;
        ListNode prev=null; ListNode curr=temp;
        while (curr !=null){
            ListNode fwd= curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;

        }
        A=prev;
        return A;
    }
}
class ListNode {
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
