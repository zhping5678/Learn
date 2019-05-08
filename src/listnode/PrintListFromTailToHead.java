package listnode;

import java.util.ArrayList;
import java.util.Collections;

public class PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result=new ArrayList<>();
        if(listNode!=null){
            result.add(listNode.val);
            while (listNode.next!=null){
                result.add(listNode.next.val);
                listNode=listNode.next;
            }
        }
        Collections.reverse(result);
        return result;
    }
}
