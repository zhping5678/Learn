package treenode;

import java.util.ArrayList;

//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class PrintTree {

    //使用数组和队列,把每一行的节点按从左到右的顺序存储起来
    //并且保证队列中的节点都是同一行的
    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> nodes=new ArrayList<>();

            if(root==null){
                return nodes;
            }
            ArrayList<TreeNode> queue=new ArrayList<>();
            queue.add(root);
            while (queue.size()!=0){
                TreeNode tmp=queue.remove(0);
                if(tmp.left!=null){
                    queue.add(tmp.left);
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                }
                nodes.add(tmp.val);
            }
            return nodes;
        }
    }
}
