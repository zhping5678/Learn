package listnode;

public class MergeList {

    public ListNode merge(ListNode list1, ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode result=null;
        ListNode head=null;
        if(list1.val<list2.val){
            result=list1;
            list1=list1.next;
        }else{
            result=list2;
            list2=list2.next;
        }
        head=result;
        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                result.next=list1;
                list1=list1.next;
            }else{
                result.next=list2;
                list2=list2.next;
            }
            result=result.next;
        }
        while (list1!=null){
            result.next=list1;
            list1=list1.next;
        }
        while (list2!=null){
            result.next=list2;
            list2=list2.next;
        }
        return head;
    }
}
