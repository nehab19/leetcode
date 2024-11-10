package guru.springframework.spring5webapp.leetcode.LinkedList;

public class  AddTwoLinkedList {
    static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        int sum = 0;
        int carry = 0;
        ListNode answer = new ListNode();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            answer.val = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(carry);
            newNode.next = answer;
            answer = newNode;
            sum = carry;
        }
        return carry == 0 ? answer.next : answer;
    }
}
