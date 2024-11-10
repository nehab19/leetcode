package guru.springframework.spring5webapp.leetcode.LinkedList;

public class MergeKSortList {
    public ListNode mergeKLists(ListNode[] lists) {
        int size=lists.length;
        if(size==0){
            return null;
        }
        return partitionAndMerge(0,size-1,lists);
    }

    //to merge two lists
    ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoList(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoList(list1, list2.next);
            return list2;
        }
    }

    ListNode partitionAndMerge(int start, int end,ListNode[] lists){
        if(start==end){
            return lists[start];
        }
        if(start > end){
            return null;
        }
        int mid=start+ (end-start)/2;
        ListNode list1=partitionAndMerge(start,mid,lists);
        ListNode list2=partitionAndMerge(mid+1,end,lists);
        return mergeTwoList(list1,list2);
    }
}
