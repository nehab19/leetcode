package guru.springframework.spring5webapp.leetcode.LinkedList;

public class  OddEvenList {
    public ListNode oddEvenList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode oddList=head;
        ListNode evenList=head.next;
        ListNode evenStart=head.next;

        while(evenList!=null && evenList.next!=null){
            oddList.next=evenList.next;
            evenList.next=evenList.next.next;
            oddList=oddList.next;
            evenList=evenList.next;
        }
        oddList.next=evenStart;
        return head;
    }
}
