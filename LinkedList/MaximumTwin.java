package guru.springframework.spring5webapp.leetcode.LinkedList;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumTwin {
    public int pairSumApproach1(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }

        int i = 0, j = arrayList.size() - 1;
        int result = 0;
        while (j > i) {
            result = Math.max(result, (arrayList.get(i) + arrayList.get(j)));
            i++;
            j--;
        }
        return result;

    }

    public int pairSumApproach2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode currentNode = head;
        while (currentNode != null) {
            stack.push(currentNode.val);
            currentNode = currentNode.next;
        }
        //need to be bring current node back to head
        currentNode = head;
        int count = 1;
        int result = 0;
        int size = stack.size();

        while (count <= size / 2) {
            result = Math.max(result, (currentNode.val + stack.peek()));
            currentNode = currentNode.next;
            stack.pop();
            count++;
        }
        return result;

    }

    public int pairSumApproach3(ListNode head) {
        ListNode middleNode = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        middleNode=slow;

        ListNode nextNode=null;
        ListNode previousNode=null;

        //reversing the list
        while(middleNode!=null){
            nextNode=middleNode.next;
            middleNode.next=previousNode;
            previousNode=middleNode;
            middleNode=nextNode;
        }

        ListNode currentNode=head;
        int result=0;
        while(previousNode!=null){
            result=Math.max(result, (currentNode.val+previousNode.val));
            currentNode=currentNode.next;
            previousNode=previousNode.next;
        }
        return result;
    }
}

