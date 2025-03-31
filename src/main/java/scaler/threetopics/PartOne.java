package scaler.threetopics;

public class PartOne {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
//        head.next.next.next.next.next.next=new ListNode(2);
        int B=2;
        ListNode answer=reverseList(head,B);
        System.out.println("so");
    }
    public static ListNode reverseList(ListNode A, int B) {
        if(A==null)return null;
        //Make the jump
        ListNode temp=A;
        int i=1;
        while (i<B){
            temp=temp.next;;
            i++;
        }
        ListNode some=reverseList(temp.next,B);
        ListNode prev=null;
        ListNode curr=A;
        int k=B;
        while(k !=0){
            ListNode future=curr.next;
            curr.next=prev;
            prev=curr;
            curr=future;
            k--;
        }
        int j=B;
        ListNode stuff=temp;
        while (j!=1){
            stuff=stuff.next;
            j--;
        }
        stuff.next=some;
        return prev;

    }
    public static int lPalin(ListNode A) {
        if(A.next==null) return 1;
        //Find the mid-point of LL
        ListNode slow=A;
        ListNode fast=A;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //Reverse the remaining half
//        ListNode mid=slow.next;
        ListNode curr=slow;
        ListNode prev=null;
        while(curr !=null){
            ListNode future=curr.next;
            curr.next=prev;
            prev=curr;
            curr=future;
        }

        ListNode head=A;
        while (prev!=null){
            if(head.val!= prev.val)return 0;
            head=head.next;
            prev=prev.next;
        }
        return 1;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
