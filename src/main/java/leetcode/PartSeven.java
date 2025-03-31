package leetcode;

import java.util.List;
import java.util.Stack;

public class PartSeven {
    public static void main(String[] args) {
        ListNode head=new ListNode(2);
        head.next=new ListNode(3);
        head.next.next=new ListNode(4);
        head.next.next.next=new ListNode(0);
        head.next.next.next.next=new ListNode(1);
        head.next.next.next.next.next=new ListNode(0);
        head.next.next.next.next.next.next=new ListNode(-1);
        head.next.next.next.next.next.next.next=new ListNode(3);
        //partition(head,2);
        Stack<Integer> stack=new Stack<>();
        String A="(a+(a+b))";
        System.out.println(braces(A));
    }
    public static int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == ')') {
                int count = 0;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    count++;
                }
                stack.pop();
                if (count > 1) {
                    stack.push('x');
                }
                else return 1;
            }
            else {
                stack.push(ch);
            }
        }
        return 0;
    }
    public static ListNode partition(ListNode A, int B) {
        ListNode smallHead=new ListNode(-1);
        ListNode largeHead=new ListNode(-1);
        ListNode smallIterator=smallHead;
        ListNode largeIterator=largeHead;
        ListNode temp=A;
        while (temp!=null){

           if(temp.val<B){
              smallIterator.next=temp;
              smallIterator=smallIterator.next;
           }
           else {
               largeIterator.next=temp;
               largeIterator=largeIterator.next;
           }
           temp=temp.next;
        }
        /*if(smallHead.next==null || largeHead.next==null) return A;
        ListNode tempo=smallHead;
        while (tempo.next!=null){
            tempo=tempo.next;
        }
        tempo.next=largeHead.next;
        return smallHead.next; */
        smallIterator.next=largeHead.next;
        largeIterator.next=null;
        return smallHead.next;

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1=list1; ListNode temp2=list2;
        if(temp1==null && temp2==null) {
            return null;
        }
//        else if(temp1==null){
//            return temp2;
//        }
//        else if(temp2==null){
//            return temp1;
//        }

        ListNode head=new ListNode(-1);
//        if(temp1.val<temp2.val) {
//            head=temp1;
//            temp1=temp1.next;
//        }
//        else{
//            head=temp2;
//            temp2=temp2.next;
//        }
        ListNode iterator=head;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                iterator.next=temp1;
                temp1=temp1.next;
                iterator=iterator.next;
            }
            else {
                iterator.next=temp2;
                temp2=temp2.next;
                iterator=iterator.next;
            }
        }
        if(temp1==null) iterator.next=temp2;
        if(temp2==null) iterator.next=temp1;
        return head;
    }
    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        ListNode temp= head; ListNode temp2=head;
        while (temp !=null){
            stack.add(temp.val);
            temp=temp.next;
        }
        while(!stack.isEmpty() && temp2 !=null){
            if(stack.pop() !=temp2.val) return false;
            temp2=temp.next;
        }
        return true;
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy; ListNode curr=head;
        while(curr!=null){
            if(curr.val==val) {
                prev.next = curr;
                curr=curr.next;
            }
            else{
                prev=curr;
                curr=curr.next;
            }
        }
        return dummy.next;
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode=new ListNode(-501);
        dummyNode.next=head;
        ListNode temp=dummyNode;
        int jumps=0;
        while(jumps !=left-1){
            temp=temp.next;
            jumps++;
        }
        ListNode farLeft=temp;
        ListNode iteratorTwo=temp.next;
        ListNode mainIterator=temp.next;
        int secondJumps=0;
        while (secondJumps!=right-left){
            iteratorTwo=iteratorTwo.next;
            secondJumps++;
        }
        ListNode farRight=iteratorTwo.next;
        iteratorTwo.next=null;
        //Consider mainIterator as the head to reverse
        ListNode prev=null;
        ListNode curr=null;
        ListNode future=mainIterator;
        while (future!=null){
            curr=future;
            future=future.next;
            curr.next=prev;
            prev=curr;
        }
        farLeft.next=prev;
        ListNode temp2=farLeft;
        while (temp2 !=null &&temp2.next !=null){
            temp2=temp2.next;
        }
        temp2.next=farRight;

        return head;
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=null;
        ListNode future=head;
        while(future !=null){
            curr=future;
            future=future.next;
            curr.next=prev;
            prev=curr;
        }
        return prev;
    }
    public static ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=slow;
        while(fast!=null &&fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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
