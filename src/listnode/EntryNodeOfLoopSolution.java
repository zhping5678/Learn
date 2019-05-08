package listnode;

//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
public class EntryNodeOfLoopSolution {


    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead==null||pHead.next==null) return null;
        ListNode current=pHead;
        while (current!=null){
            ListNode next=current.next;
            while (next!=null){
                if (next.next==current){
                    return current;
                }else{
                    next=next.next;
                }
            }
            current=current.next;
        }
        return null;
    }
}
