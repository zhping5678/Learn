package treelistnode;

public class Main {

    public static void main(String[] args){
        TreeLinkNode root=new TreeLinkNode(8);
        TreeLinkNode l1_1=new TreeLinkNode(6);
        TreeLinkNode l1_2=new TreeLinkNode(10);

        TreeLinkNode l2_1=new TreeLinkNode(5);
        TreeLinkNode l2_2=new TreeLinkNode(7);
        TreeLinkNode l2_3=new TreeLinkNode(9);
        TreeLinkNode l2_4=new TreeLinkNode(11);

        root.left=l1_1;
        root.right=l1_2;

        l1_1.left=l2_1;
        l1_1.right=l2_2;
        l1_1.next=root;

        l1_2.left=l2_3;
        l1_2.right=l2_4;
        l1_2.next=root;

        l2_1.next=l1_1;
        l2_2.next=l1_1;
        l2_3.next=l1_2;
        l2_4.next=l1_2;

        System.out.println(new GetNextSolution().GetNext(l2_1).val);
    }
}
