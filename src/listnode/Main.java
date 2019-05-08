package listnode;

public class Main {

    public static void main(String[] args){

        ListNode one=new ListNode(1);
        ListNode two=new ListNode(3);
        ListNode three=new ListNode(4);
        ListNode four=new ListNode(7);
        one.next=two;
        two.next=three;
        three.next=four;
        four.next=two;

//        ListNode one1=new ListNode(2);
//        ListNode two1=new ListNode(4);
//        listnode three1=new listnode(6);
//        listnode four1=new listnode(8);
//        one1.next=two1;
//        two1.next=three;
        System.out.println(new EntryNodeOfLoopSolution().EntryNodeOfLoop(one).val);

    }
}
