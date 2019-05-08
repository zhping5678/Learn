package listnode;


//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
//例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class DeleteDuplication {

    //使用三个指针
    public ListNode deleteDuplication(ListNode pHead)
    {
        if( pHead==null || pHead.next==null){
            return pHead;
        }
        //新建一个头节点，防止原头节点因为重复被删除
        ListNode headOfHead=new ListNode(-1);
        headOfHead.next=pHead;
        ListNode pre=headOfHead;
        ListNode current=pHead;
        ListNode next=null;
        while (current!=null && current.next!=null){
            next=current.next;
            if(next.val==current.val){
                //如果是重复的，删除
                while (next!=null && next.val==current.val){//找到所有重复的
                    next=next.next;
                }
                pre.next=next;
                current=next;
            }else{
                //不重复，向后移动
                pre=current;
                current=current.next;
            }
        }
        return headOfHead.next;
    }

    //使用递归
    public ListNode deleteDuplication2(ListNode pHead){
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        if(pHead.val==pHead.next.val){//头节点和后续节点重复
            ListNode current=pHead.next.next;
            while (current!=null && current.val==pHead.val){
                current=current.next;
            }
            return deleteDuplication2(current);
        }else{
            //头节点可以保留
            pHead.next=deleteDuplication2(pHead.next);
            return pHead;
        }
    }
}