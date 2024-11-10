package guru.springframework.spring5webapp.leetcode.LinkedList;

public class CycleList {
    public ListNode detectCycle(ListNode head){
        if(head==null || head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(slow!=fast){
            return null;
        }

        ListNode entryValue=head;
        while(entryValue!=slow){
            entryValue=entryValue.next;
            slow=slow.next;
        }
        return slow;
    }
}
