package guru.springframework.spring5webapp.leetcode.LinkedList;

import guru.springframework.spring5webapp.linkedlist.AddFirst;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ListToBinaryTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrevious = null;

        while (fast != null && fast.next != null) {
            slowPrevious = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        slowPrevious.next = null;
        //root left will the starting point of list
        root.left = sortedListToBST(head);
        //root right would be the next to slow
        root.right = sortedListToBST(slow.next);
        return root;
    }



    public static void main(String[] args) {
        ListNode listNode=new ListNode();
        listNode.addLast(-10);
        listNode.addLast(-3);
        listNode.addLast(0);
        listNode.addLast(5);
        listNode.addLast(9);
        listNode.display();
        ListToBinaryTree listToBinaryTree=new ListToBinaryTree();
        System.out.println(listToBinaryTree.sortedListToBST(listNode.head));

    }
}
