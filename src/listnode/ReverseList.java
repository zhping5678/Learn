package listnode;

//输入一个链表，反转链表后，输出新链表的表头。
public class ReverseList {

    //想法：保留当前节点的前继和后继节点，实现链表断开再连接
    public ListNode reverseList(ListNode head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode result=null;
        ListNode pre=null;
        ListNode current=head;
        ListNode tmp=null;
        while (current!=null){
            tmp=current.next;
            current.next=pre;
            if(tmp==null){
                result=current;
            }
            pre=current;
            current=tmp;
        }
        return result;
    }

    //想法：递归,利用递归走到链表的末端，然后再更新每一个node的next值,实现链表的反转
    public ListNode reverseListByRecursive(ListNode head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode reversedHead=reverseListByRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return reversedHead;
    }
}
