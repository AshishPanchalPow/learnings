package org.advanced.partThree;

public class LinkedListThree {
    public static void main(String[] args) {
        ListNode head=setupData();
        //reverseBetween(head,2,4);
        partition(head, 3);
    }

    private static ListNode partition(ListNode head, int x) {
        ListNode headSmall=null; ListNode headLarge=null;
        ListNode temp=head;
        while (temp !=null){
            if(temp.data <x){
                if(headSmall ==null){
                    headSmall=new ListNode(temp.data);
                }
                else{
                    //iterate till end and insert
                    ListNode t=headSmall;
                    while (t.next !=null){
                        t= t.next;
                    }
                    t.next=new ListNode(temp.data);
                }
            }
            else{
                if(headLarge ==null){
                    headLarge=new ListNode(temp.data);
                }
                else{
                    //iterate till end and insert
                    ListNode t=headLarge;
                    while (t.next !=null){
                        t= t.next;
                    }
                    t.next=new ListNode(temp.data);
                }
            }
            temp=temp.next;
        }
        //System.out.println("Something");
        //Iterate over small
        ListNode temporary=headSmall;
        while (temporary.next !=null){
            temporary=temporary.next;
        }
        temporary.next=headLarge;
        return headSmall;
    }

    private static ListNode setupData(){
        ListNode n1=new ListNode(1);
        n1.next=new ListNode(1);
//        n1.next.next=new ListNode(2);
//        n1.next.next.next=new ListNode(0);
//        n1.next.next.next.next=new ListNode(5);
//        n1.next.next.next.next.next=new ListNode(2);
        return n1;
    }
    private static ListNode reverseBetween(ListNode head, int left, int right){
        if(left==right) return head;
        //Find the pointer after which things will change
        ListNode dummyNode=new ListNode(-1000);
        dummyNode.next=head;
        int counter=1;
        ListNode head1=dummyNode;
        ListNode head2=dummyNode.next;
        while(head2 !=null && counter !=left){
            head2=head2.next;
            head1=head1.next;
            counter++;
        }
        ListNode head3=head2.next;
        while(head3 !=null && counter !=right){

            head3=head3.next;
            counter++;
        }
        int noOfReverse=right-left+1;
        int ctr=0;
        ListNode prev=null;
        ListNode curr=head2;
        while (curr !=null && ctr !=noOfReverse){
            ListNode fwd=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fwd;
            ctr++;
        }
        head1.next=prev;
        ListNode iterator=prev;
        while (iterator.next !=null){
            iterator=iterator.next;
        }
        iterator.next=head3;
        return dummyNode.next;
    }
}
