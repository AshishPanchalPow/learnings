//package org.leetcode;
//
//import java.util.List;
//
//public class LinkedListProblems {
//    public static void main(String[] args) {
//        System.out.println("Linked List problems");
//        ListNode head=setUp();
//        //removeNthFromEndOptimal(head,1);
//        //rotateRight(head,2);
//        ListNode listNode=swapPairs(head);
//        System.out.println("Yo");
//    }
//    private static ListNode swapPairs(ListNode head){
//        if(head==null||head.next==null) return head;
//        ListNode prev=null;
//        ListNode curr=head;
//        ListNode fwd=null;
//        int ctr=0;
//        while(ctr !=2 && curr !=null){
//            fwd=curr.next;
//            curr.next=prev;
//            prev=curr;
//            curr=fwd;
//            ctr++;
//        }
//        if(fwd !=null)head.next=swapPairs(fwd);
//        return prev;
//
//    }
//    private static ListNode setUp(){
//        ListNode n1=new ListNode(10);ListNode n2=new ListNode(20); ListNode n3=new ListNode(30); ListNode n4=new ListNode(40); ListNode n5=new ListNode(50);
//        ListNode n6=new ListNode(60);
////        n1.next=n2;
////        n2.next=n3;n3.next=n4; n4.next=n5;n5.next=n6;
//        return n1;
//    }
//    public static ListNode rotateRight(ListNode head, int k) {
//        int length=0;
//        ListNode temp=head;
//        while (temp !=null){
//            length++; temp=temp.next;
//        }
//        k=k%length;
//        if(k==0) return head;
//        ListNode p1=head; ListNode p2=head;
//        int c=0;
//        while(c<k){
//            p2=p2.next;
//            c++;
//        }
//
//        ListNode p2I=p2.next;
//        p2.next=null;
//        while(p2I.next !=null){
//            p2I=p2.next;
//            p1=p1.next;
//        }
//
//        ListNode newHead=p1;
//        ListNode tempo=newHead;
//        while (tempo.next !=null){
//            tempo=tempo.next;
//        }
//        tempo.next=head;
//        return newHead;
//
//    }
//    private static ListNode removeNthFromEndOptimal(ListNode head, int n) {
//         ListNode p1=head; ListNode p2=head;
//         int ctr=0;
//         while(p2 !=null && ctr !=n){
//             ctr++;
//             p2=p2.next;
//         }
//         while (p2.next !=null){
//             p1=p1.next;
//             p2=p2.next;
//         }
//         ListNode c=p1.next;
//         p1.next=c.next;
//         return head;
//    }
//    private static ListNode removeNthFromEnd(ListNode head, int n){
//        ListNode temp=head;
//        int totalLength=0;
//        while (temp !=null){
//            temp=temp.next;
//            totalLength++;
//        }
//        if(n==totalLength) return head.next;
//        int nodeToRemove=totalLength-n; // 0 based indexing
//        int ctr=0;
//        ListNode iterator=head;
//        while(ctr !=nodeToRemove-1){
//            iterator=iterator.next;
//            ctr++;
//        }
//        ListNode curr=iterator.next;
//        iterator.next=curr.next;
//        return head;
//    }
//}
//
//class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
