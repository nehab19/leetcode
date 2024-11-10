package guru.springframework.spring5webapp.leetcode.LinkedList;

import guru.springframework.spring5webapp.linkedlist.AddLast;

public class ListNode {
        int val;
        ListNode next;
        ListNode head;
        ListNode tail;
        int size;

        ListNode(int x) {
            val = x;
        }
        ListNode(){};

        public void addFirst(int val) {
            ListNode newNode = new ListNode();
            newNode.val = val;
            newNode.next = head;
            head = newNode;
        }

        public void display() {
            ListNode currentNode = head;
            while (currentNode != null) {
                System.out.println("data: " + currentNode.val);
                currentNode = currentNode.next;
            }
            System.out.println();
        }
        void addLast(int val) {
            ListNode newNode = new ListNode();
            if (size == 0){
                newNode.val = val;
                newNode.next = null;
                head=tail=newNode;
                size++;
            }else{
                newNode.val = val;
                newNode.next = null;
                tail.next = newNode;
                tail=newNode;
                size++;
            }

        }
    }
