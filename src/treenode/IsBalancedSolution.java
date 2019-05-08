package treenode;

import java.util.ArrayList;

//输入一颗二叉树，判断是否是平衡二叉树
public class IsBalancedSolution {
    //比较好的做法，从底层遍历，如果不平衡，直接返回，只遍历一次
    public boolean IsBalanced_Solution2(TreeNode root){
        return getDepth(root)!=-1;
    }
    private int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDepth=getDepth(root.left);
        if(leftDepth==-1){
            return -1;
        }
        int rightDepth=getDepth(root.right);
        if(rightDepth==-1){
            return -1;
        }
        return Math.abs(leftDepth-rightDepth)>1? -1: 1+Math.max(leftDepth,rightDepth);
    }


    //我的粗暴做法，从上到下，遍历每个节点，判断是否平衡——问题：下层的节点被遍历很多次
    public boolean IsBalanced_Solution(TreeNode root){
        if(root==null){
            return true;
        }
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        if(Math.abs(leftDepth-rightDepth)>1){
            return false;
        }else{
            return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
        }
    }

    public int TreeDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int depth=0;
        ArrayList<TreeNode> nodes=new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int low=0;
            int high=nodes.size();
            while (low<high){
                TreeNode node=nodes.remove(0);
                if (node.left!=null) nodes.add(node.left);
                if (node.right!=null) nodes.add(node.right);
                low++;
            }
            depth++;
        }
        return depth;
    }
}
