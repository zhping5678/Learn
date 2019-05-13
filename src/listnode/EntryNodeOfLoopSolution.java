package listnode;

import java.util.HashSet;
import java.util.Set;

//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
public class EntryNodeOfLoopSolution {


    //剑指Offer想法,链接https://blog.csdn.net/HelloZEX/article/details/81087398
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead==null||pHead.next==null) return null;

        ListNode fast=pHead;
        ListNode slow=pHead;
        while (slow!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                fast=pHead;
                while (slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    //其实最简单粗暴的方式，用过额外数组set存储节点，出现第二次就是入口
    public ListNode EntryNodeOfLoop2(ListNode pHead){
        if(pHead==null||pHead.next==null) return null;
        Set set=new HashSet();
        ListNode next=pHead;
        while (next!=null){
            if(set.contains(next)){
                return next;
            }else{
                set.add(next);
                next=next.next;
            }
        }
        return null;
    }

    //还有一种破坏原链表结构的做法，这种题目一般应该会要求不许改变原链接,并且这个似乎没办法在无环时候返回null
    //断链法
    public ListNode EntryNodeOfLoop3(ListNode pHead){
        if(pHead==null || pHead.next==null) return null;
        ListNode fast = pHead.next;
        ListNode slow = pHead;
        while (fast!=null){
            slow.next=null;
            slow=fast;
            fast=fast.next;
        }
        return slow;
    }
}
