package listnode;

public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }

    public static void printList(ListNode head){
        StringBuffer s=new StringBuffer();
        while (head!=null){
            s.append(head.val);
            if(head.next!=null){
                s.append(" -> ");
            }
            head=head.next;

        }
        System.out.println( s.toString());
    }

}
