package treenode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        TreeNode root=new TreeNode(8);
        TreeNode l1_1=new TreeNode(6);
        TreeNode l1_2=new TreeNode(10);

        TreeNode l2_1=new TreeNode(5);
        TreeNode l2_2=new TreeNode(7);
        TreeNode l2_3=new TreeNode(9);
        TreeNode l2_4=new TreeNode(11);


//        TreeNode l3_2=new TreeNode(9);
//        TreeNode l4_1=new TreeNode(1);


        root.left=l1_1;
        root.right=l1_2;

        l1_1.left=l2_1;
        l1_1.right=l2_2;
        l1_2.left=l2_3;
        l1_2.right=l2_4;

//        l2_2.left=l3_2;
//        l3_2.right=l4_1;

//        System.out.println(new SerializeSolution().Serialize(root));
        TreeNode result=new SerializeSolution().Deserialize("8 6 5 # # 7 # # 10 9 # # 11 # # ");

        ArrayList<ArrayList<Integer>> r=new PrintByLine().Print(result);
        for (ArrayList<Integer> a:r){
            for (int i:a){
                System.out.print(i+" ");
            }
            System.out.println();
        }


//        l2_2.left=l3_2;
//        l3_2.right=l4_1;

//        System.out.println(new TreeDepth().TreeDepth_Solution1(root));

//        ArrayList<ArrayList<Integer>> result=new PrintZSolution().Print2(root);
//        for(ArrayList<Integer> al:result){
//            for(Integer i:al){
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }
    }
    public static void print2(TreeNode node){
        while (true){
            if(node.right==null){
                break;
            }
            node=node.right;
        }
        System.out.print("从右到左:");
        while (true){
            if(node.left==null){
                break;
            }
            System.out.print(node.val+ " ");
            node=node.left;
        }
        System.out.print(node.val);
        System.out.print("\n从左到右:");
        while (node!=null){
            System.out.print(node.val+" ");
            node=node.right;
        }
    }

    public static void printDoubleLinkedList(TreeNode node){
        ArrayList<Integer> vals=new ArrayList<>();
        TreeNode temp=node;
        while (temp!=null){
            vals.add(temp.val);
//            System.out.print(temp.val+" ");
            temp=temp.right;
        }
        TreeNode temp2=node.left;
        while (temp2!=null){
            vals.add(0,temp2.val);
            temp2=temp2.left;
        }
        System.out.println("链表从左到右");
        for (Integer i:vals){
            System.out.println(i+" ");
        }
    }
}
