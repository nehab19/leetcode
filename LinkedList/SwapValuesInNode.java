package guru.springframework.spring5webapp.leetcode.LinkedList;

public class SwapValuesInNode {
    public int findLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public ListNode swapNodesApproach1(ListNode head, int k) {

        int length = findLength(head);
        int indexFromBeginning = k;
        ListNode nodeFromBegin = head;
        while (indexFromBeginning > 1) {
            nodeFromBegin = nodeFromBegin.next;
            indexFromBeginning--;
        }

        int indexFromEnd = length - k + 1;
        ListNode nodeFromEnd = head;
        while (indexFromEnd > 1) {
            nodeFromEnd = nodeFromEnd.next;
            indexFromEnd--;
        }

        //swap the nodes
        int tempValue = nodeFromBegin.val;
        nodeFromBegin.val = nodeFromEnd.val;
        nodeFromEnd.val = tempValue;
        return head;

    }

    public ListNode swapNodesApproach2(ListNode head, int k) {
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode temp = head;

        while (temp != null) {

            //at first p2 is not active it will become active when p1 gets its node
            if (p2 != null) {
                p2 = p2.next;
            }
            k--;
            if (k == 0) {
                p1 = temp;
                p2 = head;
            }
            temp = temp.next;
        }
        //swap the values
        int tempValue = p1.val;
        p1.val = p2.val;
        p2.val = tempValue;
        return head;
    }
}
