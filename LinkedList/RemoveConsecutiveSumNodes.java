package guru.springframework.spring5webapp.leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveConsecutiveSumNodes {
    public static ListNode removeZeroSumSublists(ListNode head) {
        int prefixSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        map.put(0, dummyNode);

        while (head != null) {
            prefixSum = prefixSum + head.val;

            if (map.containsKey(prefixSum)) {
                //delete the value from the start till head
                ListNode point = map.get(prefixSum);
                ListNode startPointer = point;
                //it will get the sum same as before to get deleted from map
                int pointSum = prefixSum;
                while (startPointer != head) {
                    startPointer = startPointer.next;
                    pointSum = pointSum + startPointer.val;
                    if (startPointer != head) {
                        map.remove(pointSum);
                    }
                }
                point.head = startPointer.next;
            } else {
                map.put(prefixSum, head);
            }
            head = head.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.addLast(1);
        listNode.addLast(2);
        listNode.addLast(3);
        listNode.addLast(-3);
        listNode.addLast(4);
        removeZeroSumSublists(listNode.head);

    }
}
