package listnode;

public class FindFirstCommonNode {

    public ListNode FindFirstCommonNode_Solution(ListNode pHead1, ListNode pHead2){
        if(pHead1==null||pHead2==null){
            return null;
        }
        if(pHead1==pHead2){
            return pHead1;
        }
        ListNode list1=pHead1;
        while (list1!=null){
            ListNode list2=pHead2;
            while (list2!=null){
                if(list1==list2){
                    return list1;
                }
                list2=list2.next;
            }
            list1= list1.next;
        }
        return null;
    }

    //别人的nb解法
    //第一遍先走出两个链表的长度差
    public ListNode FindFirstCommonNode_Solution2(ListNode pHead1, ListNode pHead2){
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while (p1!=p2){
            p1= ( p1==null? pHead2: p1.next);
            p2= ( p2==null? pHead1: p2.next);
        }
        return p1;
    }
}
