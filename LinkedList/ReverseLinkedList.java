package guru.springframework.spring5webapp.leetcode.LinkedList;

public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode previousNode = dummyNode;
        //get previous pointer before the left

        for (int i = 1; i < left; i++) {
            previousNode = previousNode.next;
        }
        ListNode currentNode = previousNode.next;

        for (int i = 1; i <=right - left; i++) {
            ListNode temp = previousNode.next;
            previousNode.next = currentNode.next;
            currentNode.next = currentNode.next.next;
            previousNode.next.next = temp;
        }
        return dummyNode.next;
    }
}
