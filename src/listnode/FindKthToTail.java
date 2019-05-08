package listnode;

//输入一个链表，输出该链表中倒数第k个结点。
public class FindKthToTail {

    //想法：两个指针，最开始都指向头节点，让第二个先走k-1步，然后两个指针一起后移，第一个指针的位置就是第k个
    public ListNode FindKthToTail(ListNode head,int k) {
        //空链表
        if(head==null||k<=0){
            return null;
        }
        ListNode first=head;
        ListNode second=head;
        int count=k;
        while(count>1){
            if(second.next==null){//如果k大于链表长度
                return null;
            }else{
                second=second.next;
                count--;
            }

        }
        while(second.next!=null){
            first=first.next;
            second=second.next;
        }
        return first;
    }
}
