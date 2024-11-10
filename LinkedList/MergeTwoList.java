package guru.springframework.spring5webapp.leetcode.LinkedList;

public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummyNode=new ListNode(-1);
        ListNode temp=dummyNode;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next=list1;
                list1=list1.next;
            }else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if(list1!=null){
            temp.next=list1;
        }else if(list2!=null){
            temp.next=list2;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode();
        listNode.addLast(1);
        listNode.addLast(4);
        listNode.addLast(5);
        ListNode listNode2=new ListNode();
        listNode2.addLast(2);
        listNode2.addLast(6);
        MergeTwoList listToBinaryTree=new MergeTwoList();
        //System.out.println(listToBinaryTree.mergeTwoLists(listNode.head,listNode2.head));
        System.out.println(listToBinaryTree.mergeTwoLists2(listNode.head,listNode2.head));
    }
}
