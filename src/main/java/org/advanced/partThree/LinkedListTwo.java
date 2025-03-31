package org.advanced.partThree;


public class LinkedListTwo {
    public static void main(String[] args) {
        System.out.println("Linked List Part two problems");
        ListNode A=setupData();
        //A=breakCycle(A);
        //swapPairs(A);
        A=reOrderList(A);
        System.out.println(A);
        ListNode n1=new ListNode(4); ListNode n2=new ListNode(1); ListNode n3=new ListNode(8); ListNode n4=new ListNode(4);ListNode n5=new ListNode(5);
        ListNode N1=new ListNode(5);ListNode N2=new ListNode(6); ListNode N3=new ListNode(1);
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;
        N1.next=N2; N2.next=N3;N3.next=n3;
        ListNode ans=getIntersectionNode(n1, N1);
        System.out.println("some");
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        // We can reverse one LL. Let us reverse B
        headA=revList(headA);
        headB=revList(headB);
        //System.out.println("Reversed");
        ListNode tempA=headA;
        ListNode tempB=headB;
        while (tempA !=null && tempB !=null ){
            if(tempA==tempB) return tempA;
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return null;
    }
    public static ListNode revList(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr !=null){
            ListNode fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
        }
        head=prev;
        return head;
    }
    public static ListNode getIntersectionNodeBig(ListNode headA, ListNode headB){
        if(headA.equals(headB)) return headA;
        ListNode ans1= check(headA,headB);
        ListNode ans2= check(headB,headA);
        if(ans1==null && ans2==null) return null;
        else if(ans1 !=null) return ans1;
        else return ans2;
    }
    public static ListNode check(ListNode headA, ListNode headB){
        ListNode tempB=headB;
        while (tempB !=null){
            // Src is tempB. Now iterate over tempA
            ListNode tempA=headA;
            while (tempA !=null){
                if(tempB .next !=null && tempB.next.equals(tempA)) return tempA;
                tempA=tempA.next;
            }
            tempB=tempB.next;
        }
        return null;
    }
    public static ListNode reOrderList(ListNode A){
        ListNode head=A;
        ListNode slow=head;
        ListNode fast=head;
        while (slow.next !=null && fast.next!=null && fast.next.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode mid2=slow.next;
        slow.next=null;
        //Reverse Mid2
        mid2=reverseLL(mid2);
        //Two lists denoted by head & mid2;
        ListNode first=head;
        int ctr=0;
        while(first !=null && mid2 !=null){
            ListNode t1=first.next;
            ListNode t2=mid2.next;
            if(ctr%2 ==0){
                first.next=mid2;
                first=t1;
            }
            else {
                mid2.next = first;
                mid2 = t2;
            }
            ctr++;
        }
        return head;
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
    public static ListNode reorderList(ListNode A){
        reorder(A,6);
        return A;
    }
    public static ListNode reorder(ListNode A, int N){
        if(N <0) return A;
        if(N<=2) return A;
        ListNode head=A;
        int ctr=0;
        ListNode temp=head;
        ListNode prev=temp;
        while(ctr !=N-1){
            prev=temp;
            temp=temp.next;
            ctr++;
        }
        prev.next=null;
        ListNode next=head.next;
        head.next=temp;
        temp.next=head;
        head.next=reorder(next,N-2);
        return temp;

//        prev.next=null;
//        ListNode n=head.next;
//        head.next=temp;
//        temp.next=n;
//        n.next=reorder(n,N-2);;
//        return temp;
    }
    public static ListNode swapPairs(ListNode A){
        int K=2;
        ListNode head=A;
        ListNode ans=swapKAtATime(A,K);
        return ans;
    }
    public static ListNode swapKAtATime(ListNode head, int K){
        if(head.next==null) return head;
        int ctr=0;
        ListNode prev=null;
        ListNode fwd=null;
        ListNode curr=head;
        while (ctr !=K){
            fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
            ctr++;
        }
        if(fwd !=null)head.next=swapKAtATime(fwd,K);
        return prev;
    }
    public static ListNode breakCycle(ListNode A){
        if(hasCycle(A) !=null){
            ListNode slow=A;
            ListNode fast=hasCycle(A);
            while(slow.next !=fast.next){
                slow=slow.next;
                fast=fast.next;
            }
            //System.out.println("Point of collision: "+slow+"Fast: "+fast);
            fast.next=null;
        }
        return A;
    }
    public static ListNode hasCycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while (slow.next !=null && fast.next.next !=null){
            if(slow !=head && fast !=head &&slow==fast) return slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        return null;
    }
    public static ListNode setupData(){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        ListNode n6=new ListNode(6);
        n1.next=n2; n2.next=n3;
        n3.next=n4;n4.next=n5;n5.next=n6;
        return n1;
    }
}
