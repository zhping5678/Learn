package randomListNode;

public class Clone {

    //参考https://www.cnblogs.com/edisonchou/p/4790090.html,三种方式,该方法为第三种
    public RandomListNode Clone(RandomListNode pHead){
        //1.复制穿串成一个长链表,克隆节点在原节点后,用next相连
        connect(pHead);
        //2.复制指向任意节点的指针random
        cloneRandomLink(pHead);
        //3.拆分成两个链表,奇数位置为原节点,偶数位置为复制节点
        return disConnectList(pHead);
    }

    public void connect(RandomListNode head){
        RandomListNode node=head;
        while (node!=null){
            RandomListNode cloned=new RandomListNode(node.label);
            cloned.next=node.next;
            cloned.random=null;

            node.next=cloned;

            node=cloned.next;
        }
    }

    public void cloneRandomLink(RandomListNode head){
        RandomListNode node=head;
        while (node != null){
            if(node.random != null){
                node.next.random=node.random.next;
            }
            node=node.next.next;
        }
    }

    public RandomListNode disConnectList(RandomListNode head){
        RandomListNode node = head;
        RandomListNode newHead = null;
        RandomListNode newNode = null;
        if( node != null){
            newHead = node.next;
            newNode = node.next;
            node.next=newHead.next;
            node=newNode.next;
        }
        while (node != null){
            newNode.next=node.next;
            newNode=node.next;
            node.next=newNode.next;
            node=node.next;
        }
        return newHead;
    }

}
