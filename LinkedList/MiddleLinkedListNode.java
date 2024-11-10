package guru.springframework.spring5webapp.leetcode.LinkedList;

public class MiddleLinkedListNode {
    public ListNode middleNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
