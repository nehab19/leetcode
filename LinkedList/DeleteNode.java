package guru.springframework.spring5webapp.leetcode.LinkedList;


public class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode previousNode=null;
        while(node!=null && node.next!=null){
            node.val=node.next.val;
            previousNode=node;
            node=node.next;
        }
        if(node!=null){
            if(previousNode!=null){
                previousNode.next=null;
            }

        }

    }
}
