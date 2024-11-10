package guru.springframework.spring5webapp.leetcode.StringOrArrays;


import java.util.Stack;

public class LinkListPalindrome {
    static class ListNode {
        ListNode next;
        int data;

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        ListNode(int data) {
            this.data = data;
        }

        ListNode() {
        }

        ;
    }

    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            stack.push(currentNode.data);
            currentNode = currentNode.next;
        }
        while (head != null) {
            int element = stack.pop();
            if (head.data != element) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        boolean result = isPalindrome(head);

        if (result)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
