package guru.springframework.spring5webapp.leetcode.LinkedList;

import java.util.ArrayList;
import java.util.Random;

public class RandomNode {
    private ArrayList<Integer> arrayList;
    private Random random;
    public RandomNode(ListNode head) {
        arrayList=new ArrayList<>();
        random=new Random();
       ListNode node=head;
       while(node!=null){
           arrayList.add(node.val);
           node=node.next;
       }
    }

    public int getRandom() {
        int size=arrayList.size();
        //to generate a random number between 0 and n and where 0 will be inclusive and n will be exclusive.
        int nextRandonNumber=random.nextInt(size);
        return arrayList.get(nextRandonNumber);
    }
}
