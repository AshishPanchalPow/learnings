package org.leetcode;

public class October {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        //createCop(n1);
        //ListNode reved=revLL(n1);
        System.out.println(magic(1291));
        System.out.println(printBinary(3));
    }
    private static String printBinary(int N){
        if(N==1) return "0";
        String str=printBinary(N-1);
        return str+doOpp(str);
    }
    private static String doOpp(String str){
        String ans="";
        for(int i=0; i<str.length();i++){
            ans +=(str.charAt(i)=='0'?"1":"0");
        }
        return ans;
    }
    private static ListNode createCop(ListNode head){
        ListNode copy=new ListNode(-1);
        ListNode currCopy=copy;
        ListNode temp=head;
        while (temp !=null){
            ListNode newNode=new ListNode(temp.val);
            currCopy.next=newNode;
            currCopy=newNode;
            temp=temp.next;
        }
        return copy.next;
    }
    private static ListNode revLL(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode rev=revLL(head.next);
        head.next.next=head;
        head.next=null;
        return rev;
    }
    private static int magic(int A){
        A=sum(A);
        if(A<10){
            return A==1?1:0;
        }
        return magic(A);
    }
    private static int sum(int num){
        if(num<10) return num;
        int localSum=0;
        while (num !=0){
            localSum += num%10;
            num=num/10;
        }
        return localSum;
    }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
